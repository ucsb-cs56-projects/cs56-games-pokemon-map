package main.java.edu.ucsb.cs56.projects.games.pokemon.IO;

import main.java.edu.ucsb.cs56.projects.games.pokemon.Assets;
import main.java.edu.ucsb.cs56.projects.games.pokemon.World;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.*;
import main.java.edu.ucsb.cs56.projects.games.pokemon.TileData;
import main.java.edu.ucsb.cs56.projects.games.pokemon.factories.*;
import main.java.edu.ucsb.cs56.projects.games.pokemon.IO.OutputError;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.System;
import java.lang.Math;
import javax.swing.*;


/**
 * Loads the Map
 *
 * @author William Bennett, modified by Lyric Luo
 */

public class MapLoader {
    int[][] tileGrid;
    OutputError Error;
    
    /**
     * Loads the map from a String and puts it into a world object
     *
     * @param inputStream the string to read from
     * @param world the world to load
     * @return return a Entity[][] with axis as indexs and Texture ID store inside
     */
    
    public Entity[][] loadMap(String inputStream, World world) {
	
        loadMap(inputStream);
        Entity[][] entities = new Entity[tileGrid.length][tileGrid[0].length];
	int widthTimes = 0;
	int heightTimes = 0;

        for (int x = 0; x < tileGrid.length; x++) {
            for (int y = 0; y < tileGrid[x].length; y++) {

		//check whether entity is larger than one grid
		if (TileData.IDToTexture(tileGrid[x][y]).width() > 16 && TileData.IDToCollision(tileGrid[x][y]) == true ){
		     widthTimes = (int) Math.ceil(TileData.IDToTexture(tileGrid[x][y]).width() / 16.0 -1) ;
		     System.out.println(new Integer (x).toString() + " " + new Integer (widthTimes).toString());
		 }
	
		
		if (TileData.IDToTexture(tileGrid[x][y]).height() > 16 && TileData.IDToCollision(tileGrid[x][y]) == true) {
		    heightTimes = (int) Math.ceil(TileData.IDToTexture(tileGrid[x][y]).height() / 16.0 -1) ;
		    System.out.println(new Integer (y).toString() + " " + new Integer (heightTimes).toString());

		}

		for(int i = widthTimes;i >= 0; i--) {
		    for (int j = heightTimes; j >= 0; j--) {

			//check whether entity goes out of map if it is larger than one grid
			if (((x+i) > tileGrid.length-1) || ((y+j) > tileGrid[x].length-1)) {
			    Error = new OutputError ("ID out of map at [" + new Integer (x).toString() + "," + new Integer (y).toString() + "]");
			}

			//check whether entity overlaps with others if it is larger than one grid
			if (tileGrid[x+i][y+j] != 0 && (i!=0 || j!=0)) {
			     Error = new OutputError ("ID overlap at [" + new Integer (x).toString() + "," + new Integer (y).toString() + "]");
			    }
	  
		    }
		    widthTimes = 0;
		    heightTimes = 0;
		}
			
		//add valid entities to map
		entities[x][y] = new Entity().
	            addComponent(new PositionComponent(x, y)).
		    addComponent(new GraphicsComponent(TileData.IDToTexture(tileGrid[x][y]))).
		    addComponent(new CollisionComponent(TileData.IDToCollision(tileGrid[x][y]), TileData.IDToTexture(tileGrid[x][y]).srcRect()));
            }
        }
	
	return entities;
    }

    private void loadMap(String inputStream) {
        // This regex matches the map format, as detailed below
        // Parens denote match boundaries
        // (map_name { // must be one word
        // 0,1,2,3,
        // // })
        Pattern allMapsRegex = Pattern.compile("([a-zA-Z_]+\\s*\\{(\\s|.)[^\\}]*\\})");
        Matcher matcher = allMapsRegex.matcher(inputStream);
        matcher.find();
        String[] allMaps = {matcher.group()};
	
        // This regex matches the tile specification for a map, as shown below
        // Parens denote match lines
        // 1,2,3,4,
	// 0,0,0,0,
	Pattern mapRegex = Pattern.compile("(\\d+(,|\\t))*");

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


	    //create arraylist tileStrings with each line matched inside
            Matcher tileMatcher = mapRegex.matcher(map);
            ArrayList<String> tileStrings = new ArrayList<>();
            while (tileMatcher.find()) {
                tileStrings.add(tileMatcher.group());
            }
	    //remove empty string
	    for (int i = 0; i < tileStrings.size(); i++) {
		if (tileStrings.get(i).isEmpty()) {
		    tileStrings.remove(i);
		}

	    }

	    //loop through each line, add ID to tileGrid
	    int yAxis = 0;
	    for (int i = 0; i < tileStrings.size(); i++) {
		String parts[] = tileStrings.get(i).split(",");
		
		//check whether more lines than excepted 
		if (yAxis >= height && !(parts[0].isEmpty())) {
		    Error = new OutputError ("More lines than excepted in text file");
		}

		//check whether more ID than excepted in one line
		if (parts.length > width && !(parts[0].isEmpty())){
		    Error = new OutputError ("More ID than excepted in line " + new Integer (yAxis+1).toString() );
		}
		
		for (int x = 0;x < parts.length; x++) {
		    //skip empty element
		    if (parts[x].isEmpty()){
			continue;
		    }
		    tileGrid[x][yAxis] = Integer.parseInt(parts[x]);		    
		}
		
		if (!parts[0].isEmpty()){
		    yAxis++;
		}
	    }
        }
    }
}
