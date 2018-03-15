package edu.ucsb.cs56.projects.games.pokemon.IO;

import edu.ucsb.cs56.projects.games.pokemon.Assets;
import edu.ucsb.cs56.projects.games.pokemon.World;
import edu.ucsb.cs56.projects.games.pokemon.components.*;
import edu.ucsb.cs56.projects.games.pokemon.TileData;
import edu.ucsb.cs56.projects.games.pokemon.factories.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.System;
import java.lang.Math;

/**
 * Loads the Map
 *
 * @author William Bennett
 */

public class MapLoader {
    int[][] tileGrid;

    /**
     * Loads the map from a String and puts it into a world object
     *
     * @param inputStream the string to read from
     * @param world the world to load
     */
    public Entity[][] loadMap(String inputStream, World world) {
        loadMap(inputStream);
        Entity[][] entities = new Entity[tileGrid.length][tileGrid[0].length];
        for (int x = 0; x < tileGrid.length; x++) {
            for (int y = 0; y < tileGrid[x].length; y++) {
		
		if (TileData.IDToTexture(tileGrid[x][y]).width() > 16 && TileData.IDToCollision(tileGrid[x][y]) == true ){
		    // if (TileData.IDToTexture(tileGrid[x][y]).width() % 16.0 != 0 ) {
		    // 	int time = TileData.IDToTexture(tileGrid[x][y]).width() / 16 + 1;
		    // }else {
		    //    	int time = TileData.IDToTexture(tileGrid[x][y]).width() / 16 ;
		    // }
		    int times = (int) Math.ceil(TileData.IDToTexture(tileGrid[x][y]).width() / 16.0) ;
		    // System.out.println(new Integer (times).toString());
		    for (int i = 1 ; i <= times-1; i++ ){
			if (tileGrid[x+i][y] != 0) {
			    throw new ArithmeticException ("Map entities overlapped");
			}
		    }
		}
		if (TileData.IDToTexture(tileGrid[x][y]).height() > 16 && TileData.IDToCollision(tileGrid[x][y]) == true) {
		    // if (TileData.IDToTexture(tileGrid[x][y]).height() % 16.0 != 0 ) {
		    // 	int times = TileData.IDToTexture(tileGrid[x][y]).height() / 16 + 1;
		    // }else {
		    //    	int times = TileData.IDToTexture(tileGrid[x][y]).height() / 16 ;
		    // }
		    int times = (int) Math.ceil(TileData.IDToTexture(tileGrid[x][y]).height() / 16.0) ;
		    //System.out.println(new Integer (times).toString());
		    for (int j = 1 ; j <= times-1; j++ ){
			if (tileGrid[x][y+j] != 0) {
			    throw new ArithmeticException ("Map entities overlapped");
			}
		    }
		}
	    

		
		 // CollisionComponent CC = (CollisionComponent)entities[x][y].getComponent(CollisionComponent.class);
		// if (CC.hasCollision) {
		//     throw new ArithmeticException ("Map entities overlapped");
		// }
		    entities[x][y] = new Entity().
		    //addComponent(new TileComponent(tileGrid[x][y])).
	            addComponent(new PositionComponent(x, y)).
		    addComponent(new GraphicsComponent(TileData.IDToTexture(tileGrid[x][y]))).
		   //addComponent(new CollisionComponent(TileData.IDToCollision(tileGrid[x][y]), TileData.IDToTexture(tileGrid[x][y]).width(),TileData.IDToTexture(tileGrid[x][y]).height()));
		    addComponent(new CollisionComponent(TileData.IDToCollision(tileGrid[x][y]), TileData.IDToTexture(tileGrid[x][y]).srcRect()));
            }
        }
        //world.tiles = entities;
	return entities;
    }

    private void loadMap(String inputStream) {
        // This regex matches the map format, as detailed below
        // Parens denote match boundaries
        // (map_name { // must be one word
        // [0, 0, 0], [0, 1, 0]
        // // })
        Pattern allMapsRegex = Pattern.compile("([a-zA-Z_]+\\s*\\{(\\s|.)[^\\}]*\\})");
        Matcher matcher = allMapsRegex.matcher(inputStream);
        matcher.find();
        String[] allMaps = {matcher.group()};

	
	
        // This regex matches the tile specification for a map, as shown below
        // Parens denote match boundaries
        // map_name { // must be one word
        // ([0, 0, 0]), ([0, 1, 0])
        // }
	// Pattern mapRegex = Pattern.compile("\\[(\\d(,|\\s)*)+\\]");
         Pattern mapRegex = Pattern.compile("(\\d+(,|\\s))");


	// This regex matches the metadata of a map, as shown below
        // Parens denote match boundaries
        /*
        (width:5)
        (height:5)
        */
        Pattern metadataRegex = Pattern.compile("\\w+:\\s*\\d+");

	
	//match and find the width and height of the map
	//create array tileGrid according to the data matched
        for (String map : allMaps) {
            int width = 0, height = 0;
            Matcher metadataMatcher = metadataRegex.matcher(map);
            ArrayList<String> metadataStrings = new ArrayList<>();
            while (metadataMatcher.find()) {
                metadataStrings.add(metadataMatcher.group());
            }
            for (String data : metadataStrings) {
                String[] keyValPair = data.split(":");
                switch (keyValPair[0]) {
                    case "width":
                        width = Integer.parseInt(keyValPair[1]);
                        break;
                    case "height":
                        height = Integer.parseInt(keyValPair[1]);
                }
            }
            tileGrid = new int[width][height];


	    
            Matcher tileMatcher = mapRegex.matcher(map);
            ArrayList<String> tileStrings = new ArrayList<>();
            while (tileMatcher.find()) {
                tileStrings.add(tileMatcher.group());
            }

	    
	    //check whether the size of ID number equals to the size of map
	    if (tileStrings.size() > width*height + 2) {
		throw new ArithmeticException ("ID numbers outof map size");
	    }
	   
	    
	    
	    for (int x = 0; x < height; x++ ) {
	    	for (int y = 0; y < width; y++) {
	    	    String tile = tileStrings.get(x*width + y + 2);
	    	    Pattern integers = Pattern.compile ("\\d+");
	    	    Matcher intMatcher = integers.matcher (tile);
	    	    intMatcher.find();
	    	    int ID = Integer.parseInt(intMatcher.group());
	    	    tileGrid[y][x] = ID;
	    	    // String s = "x"+ new Integer (y).toString() + " y" +new Integer(x).toString() + " ID"+ new Integer(ID).toString();
	    	    // System.out.println(s);
	    	}
	    }
	    
        }
    }
}
