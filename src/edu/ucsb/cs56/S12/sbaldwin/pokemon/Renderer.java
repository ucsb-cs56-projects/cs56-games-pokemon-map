package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.imageio.ImageIO;

/** The class responsible for deciding what to display to the GamePanel, and loading the buffers.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
*/

public class Renderer
{
	private Graphics buffer;
	private BufferedImage bufferImage;
	
	private Graphics finalBuffer;
	private BufferedImage finalImage;
	
	private GameGrid gg;
	
	private int width;
	private int height;
	private int bufferWidth;
	private int bufferHeight;
	
	private BufferedImage TileSet_Main;
	private BufferedImage TileSet_Characters;
    private BufferedImage TileSet_Pkmn;
	
	private int cameraX;
	private int cameraY;
	private int cameraWidth;
	private int cameraHeight;
	
	private int tileWidth;
	private int tileHeight;

    
    public static AudioClip long1, long2, long3, long4, long5, long6, long7, short3;
    
        /** Two arg constructor
	    @param width width of game screen
	    @param height height of game screen
		*/
	public Renderer(int width, int height)
	{   
		// Set Tile size
		this.tileWidth = 32;
		this.tileHeight = 32; 
		
		// Set width and height
		this.width = width;
		this.height = height;
		
		this.bufferWidth = width + (7 * tileWidth);
		this.bufferHeight = height + (7 * tileHeight);
		
		// Create the new Game Grid
		gg = new GameGrid(200, 200);
		
		// Create the buffer
		bufferImage = new BufferedImage(this.bufferWidth, this.bufferHeight, BufferedImage.TYPE_4BYTE_ABGR);
		buffer = bufferImage.getGraphics();
		
		// Create the finalBuffer
		finalImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_4BYTE_ABGR);
		finalBuffer = finalImage.getGraphics();
    		
    	ClassLoader cl = getClass().getClassLoader();
		
		// Load in TileSets

		//load in buildings and textures
		try
		{
			TileSet_Main = ImageIO.read(cl.getResource("images/TilesetMain.bmp"));
		} 
		catch(IOException ie){
			System.out.println("Error loading in Images");
		}		
	
		//load in Professor Oak sprite	
		try
		{
			TileSet_Characters = ImageIO.read(cl.getResource("images/NPC_frlg.bmp"));
		} 
		catch(IOException ie){
			System.out.println("Error loading in Images");
		}
        
		//Added in a pikachu sprite
		try
		{
		    TileSet_Pkmn = ImageIO.read(cl.getResource("images/pkmn.bmp"));
		}
		catch(IOException ie){
		    System.out.println("Error loading in Images");
		}
        
		
		if(TileSet_Characters == null)
		{
			System.out.println("Error loading in Images");
		}

		// Load sounds
		long1 = loadSound("long1.wav");
		long2 = loadSound("long2.wav");
		long3 = loadSound("long3.wav");
		long4 = loadSound("long4.wav");
		long5 = loadSound("long5.wav");
		long6 = loadSound("long6.wav");
		long7 = loadSound("long7.wav");
		short3 = loadSound("short3.wav");
		/*
		short1 = loadSound("short1.wav");
		short2 = loadSound("short2.wav");
		short4 = loadSound("short4.wav");
		*/
		
		// Make Black areas transparent
		TileSet_Main = imageToBufferedImage(makeColorTransparent(TileSet_Main, Color.black));
		
		// Make Pink areas transparent
		TileSet_Characters = imageToBufferedImage(makeColorTransparent(TileSet_Characters, new Color(255, 0, 255)));
        
		//Make White areas transparent
		TileSet_Pkmn = imageToBufferedImage(makeColorTransparent(TileSet_Pkmn, Color.white));
	}

        /** Loads the map, sets all the buildings and textures, and registers the player
	 	*/	
	public void loadMap()
	{
	    // play first background music
	    long1.play();
		Texture grass_Default = new Texture("GRASS_DEFAULT", "TileSet_Main", 16, 0, 32, 16);
		Texture grass_Wild = new Texture("GRASS_WILD", "TileSet_Main", 0, 16, 16, 32);
		Texture flower = new Texture("flower", "TileSet_Main", 16*0, 16*36, 16*1, 16*37);
		Texture flower2 = new Texture("flower2", "TileSet_Main", 16*13, 16*39, 16*14, 16*40);
		Texture flower3 = new Texture("flower3", "TileSet_Main", 16*14, 16*189, 16*15, 16*190);
		Texture rockGround = new Texture("rockGround", "TileSet_Main", 16*6, 16*10, 16*7, 16*11);		
		Texture snow = new Texture("snow", "TileSet_Main", 16*1, 16*351, 16*2, 16*352);
	        
		// first set all the map to collision free
		for(int wCounter = 0; wCounter < gg.getWidth(); wCounter ++)
		{
			for(int hCounter = 0; hCounter < gg.getHeight(); hCounter ++)
			{			
				gg.setCollisionGrid(GameGrid.GridValue.FREE, wCounter, hCounter);				
				gg.setTextureGrid(grass_Default, wCounter, hCounter, 0);
			}
		}
		    
		    		
		// Load the Wild Grass
		for(int counter1 = 43; counter1 < 49; counter1 ++)
		{
			for(int counter2 = 34; counter2 < 40; counter2 ++)
			{
				if((counter1 != 45 && counter1 != 46) || (counter2 != 36 && counter2 != 37))
					if((counter1 != 43 || counter2 != 34) && (counter1 != 48 || counter2 != 39))
						if((counter1 != 43 || counter2 != 39) && (counter1 != 48 || counter2 != 34))
						    gg.setTextureGrid(grass_Wild, counter1, counter2, 0);
				                       
			}
		}

		// Load flowers
		for(int counter1 = 0; counter1 < 28; counter1 ++)
		{
			for(int counter2 = 0; counter2 < 28; counter2 ++)
			{
				if(counter1 == 1 || counter2 == 1 || counter1 == 27 || counter2 == 27)
				{
				    int x = 37 + counter1;  
				    int y = 26 + counter2;
				    if(!(x==64 && y<38 && y>31)) {
					gg.setTextureGrid(flower, x, y, 0);
				    }				
				}
			}
		}
		
		for(int x = 55; x < 65; x ++) 
		{
		    for(int y = 27; y < 35; y ++) 
		    {
				if(!(x == 64 && y == 34))
				{
			    	gg.setTextureGrid(flower, x, y, 0);
				}
		    }
		}

		// Load the snow land
		for(int x = 130; x < 150; x++) 
		{
		    for(int y = 70; y < 100; y++) 
		    {
			 	gg.setTextureGrid(snow, x, y, 0);
		    }
		}

		// Create Trees
		for(int i = 0; i < 2; i++) 
		{
		    for(int counter1 = 0; counter1 < 30; counter1 ++)
			{
			    for(int counter2 = 0; counter2 < 30; counter2 ++)
				{
					if(counter1 == 0 || counter1 == 29 || counter2 == 0 || counter2 == 29)
				    {
						int x = 37 + counter1 + i*28;  
						int y = 25 + counter2;
						creatTree(x, y);
						//tree = new Building(x, y , "BASE_TREE_1");				    
				    }
				}
			}
		}	
		createNiceTree(45,36);
		
		for(int i = 67; i < 95; i++) 
		{
		    for(int j = 25; j < 41; j++) 
		    {
				if(!((i < 92 && i > 68) && (j > 28 && j < 38))) 
				{
			    	creatTree(i,j);
				}
				else if (!((i < 82 && i > 77) && (j > 32 && j < 36)))
				{
			    	gg.setTextureGrid(flower2, i, j, 0);  // fill the empty space with nice flowers
				}
		    }
		}		

		for(int x = 37; x < 151; x++) 
		{
		    for(int y = 25; y < 101; y++) 
		    {
				if((x==150 || y==100 || (y==25 && x>64) || (x==37 && y>50))
			   		&& (!(y==25 && x > 143) && !(x==150 && y < 32))) 
				{
			    	creatTree(x, y);
			    }
		    }
		}
		
		// Load the Buildings	
		creatPokeCenter(40, 40);
		creatPokeCenter(85, 68);
		creatPokeMart(45, 41);
		creatPokeMart(72, 69);
		creatSmallHouse(55, 35);
		creatSmallHouse(60, 35);
		creatSmallHouse(67, 68);
		creatSmallHouse(90, 68);
		creatMediumHouse(57,45);
		creatlargeHouse(41,28);
		creatbigFish(144,19);
		creatBigBuilding(100, 55);
		creatBigBuilding2(130,55);
		creatPokeball(41,99);
		createWater(115, 33, 20, 10);
		createWater(67, 42, 27, 25);
		creatdoor(77,68);
	       
		// create big pokemon in the forest
		Building bigPokemon = new Building(78, 33, "BIGPOKEMON");

		// set the ground to rockground
		for(int x=10; x<80; x++) 
		{
		    for(int y=56; y<120; y++) 
		    {
				gg.setTextureGrid(rockGround, x, y, 0);
		    }
		}

		// creat some flowers in the rockground
		for(int x=70; x<73; x++) 
		{
		    for(int y=82; y<85; y++) 
		    {
				if(!(x==71 && y==82)) {
			    	gg.setTextureGrid(flower2, x, y, 0);
				}
		    }
		}

		for(int x=70; x<73; x++) 
		{
		    for(int y=79; y<82; y++) 
		    {
				gg.setTextureGrid(flower, x, y, 0);
		    }
		}
					
		//create rockes
		for(int y=55; y<102; y++) 
		{
		    // change to trees to rocks
		    deleteTree(37, y);
		    if(y!=55) 
		    {
				creatRock(37,y);
				creatRock(45,y);
		    }
		}

		for(int x=38; x<85; x++) {
		    deleteTree(x, 100);
		    if(x != 41) 
		    {
				creatRock(x,100);
				creatRock(x,101);
		    }
		}

		for(int y=68; y<75; y++) 
		{
		    creatRock(76,y);
		    creatRock(84,y);
		}
		
		for(int x=73; x<89; x+=3) 
		{
		    creatBigRock(x,79);
		}

		for(int y=61; y<98; y+=2) 
		{
		    creatBigRock(38, y);
		    creatBigRock(42,y);		    
		}

		// Create the lake
		createWater(76, 75, 8, 3);
		
        
		//create Pikachu
		//	Player pkmn = new Player(80, 35, Character.Direction.EAST, "PIKACHU", "PIKACHU");
		Player pkmn = new Player(44, 46, Character.Direction.EAST, "PIKACHU", "PIKACHU");
		GameMain.gameLogic.registerPkmn(pkmn);
        
		// Create the player
		//	Player player = new Player(81, 35, Character.Direction.SOUTH, "PROFESSOR_OAK", "PROFESSOR_OAK");
		Player player = new Player(45, 46, Character.Direction.SOUTH, "PROFESSOR_OAK", "PROFESSOR_OAK");
		GameMain.gameLogic.registerPlayer(player);
        
       
	}

        /** Clears the buffer
	 */	
	public void startRender()
	{
		// Reset the buffer
		clearBuffer();
	}

        /** Renders the TextureGrid to the buffer
	    @param tileXStart initial x point
	    @param tileYStart initial y point
	    @param tileXEnd terminal X point
	    @param tileYEnd terminal Y point
	*/	
	// Takes in parameters for starting tile positions and finishing tile positions
	public void renderTextureGrid(int tileXStart, int tileYStart, int tileXEnd, int tileYEnd)
	{
		
		// Loop and render
		for(int tileX = tileXStart; tileX <= tileXEnd; tileX++)
		{
			// Dont render out of bounds indexes
			if(tileX < 0)
			{
				tileX = 0;
			}
			
			for(int tileY = tileYStart; tileY <= tileYEnd; tileY++)
			{
				// Dont render out of bounds indexes
				if(tileY < 0)
				{
					tileY = 0;
				}
				
				// Draw texture				
				Texture tex = gg.getTextureGrid(tileX, tileY, 0);

				//buffer.drawImage(makeColorTransparent(tex.getImage(), Color.BLACK),
				buffer.drawImage(tex.getImage(), 
					   ((tileX - tileXStart) * tileWidth), 
					   ((tileY - tileYStart) * tileHeight), 
					   ((tileX - tileXStart) * tileWidth) + tileWidth, 
					   ((tileY - tileYStart) * tileHeight) + tileHeight,
					   0,
					   0,
					   16,
					   16,
					   null);
			}
		}
	
	}

        /** Draws the object at the specified location
	    @param tileXStart
	    @param tileYStart
	    @param tileXEnd
	    @param tileYEnd
	*/
	public void renderObjectGrid(int tileXStart, int tileYStart, int tileXEnd, int tileYEnd)
	{		
		// Loop and render
		for(int tileX = tileXStart; tileX <= tileXEnd; tileX++)
		{
			// Dont render out of bounds indexs
			if(tileX < 0)
			{
				tileX = 0;
			}
			
			for(int tileY = tileYStart; tileY <= tileYEnd; tileY++)
			{
				// Dont render out of bounds indexs
				if(tileY < 0)
				{
					tileY = 0;
				}
				
				GameObject tmp = gg.getObjectGrid(tileX, tileY);
				
				if(tmp != null)
				{
					drawObject(tmp, (tileX - tileXStart), (tileY - tileYStart));
				}
			}
		}
	}

        /** Draws an object to the buffer
	    @param gObject the GameObject
	    @param tileX the horizontal position
	    @param tileY the vertical position
	*/
	// Helper Object for renderObjectGrid
	private void drawObject(GameObject gObject, int tileX, int tileY)
	{
		// Update the collision grid first
		for(int wCounter = 0; wCounter < gObject.getWidth(); wCounter ++)
		{
			for(int hCounter = 0; hCounter < gObject.getHeight(); hCounter ++)
			{
				if(gObject.getCollisionValue(wCounter, hCounter) != GameGrid.GridValue.FREE)
				{
					gg.setCollisionGrid(gObject.getCollisionValue(wCounter, hCounter),
										     (gObject.getXPos() + wCounter), 
										     (gObject.getYPos() + hCounter));
				}
			}
		}
		
		// Render object
		
		buffer.drawImage(gObject.getTexture().getImage(),
				 tileX * tileWidth + gObject.getXOffset(),
				 tileY * tileHeight + gObject.getYOffset(),
				 gObject.getWidth() * tileWidth,
				 gObject.getHeight() * tileHeight,
				 null);
	
	}

        /** Moves the buffer to the final buffer
	    @param xpos the x position
	    @param ypos the y position
	    @param xOff the x offset
	    @param yOff the y offset
	    @param width
	    @param height
	*/
	// Measured in tiles except offsets(measured in pixels)
	public void drawFinalImage(int xpos, int ypos, int xOff, int yOff, int width, int height)
	{
		finalBuffer.drawImage(bufferImage, 0, 0, this.width, this.height,
					      (xpos * tileWidth) + xOff, 
					      (ypos * tileHeight) + yOff, 
					      (xpos * tileWidth) + xOff + (width * tileWidth), 
					      (ypos * tileHeight) + yOff + (height * tileHeight), 
					      null);
		
	}
    
        /** Fills the Buffer with all black
	 */	
	public void clearBuffer()
	{
		buffer.setColor(Color.black);
		buffer.fillRect(0, 0, bufferWidth, bufferHeight);
	}
    
        /** Getter for buffer
	    @return buffer
	*/
	public Graphics getBufferGraphics()
	{
		return buffer;
	}

        /** Getter for bufferImage
	    @return bufferImage
	*/
	public BufferedImage getBufferImage()
	{
		return bufferImage;
	}
    
        /** Getter for finalImage
	    @return finalImage
	*/
	public BufferedImage getFinalImage()
	{
		return finalImage;
	}

        /** Getter for GameGrid
	    @return gg, GameGrid
	*/
	public GameGrid getGameGrid()
	{
		return gg;
	}
	
	
	
	///// The next two methods are courtesy of corgrath from:
	///// http://stackoverflow.com/questions/665406/how-to-make-a-color-transparent-in-a-bufferedimage-and-save-as-png
        /** Creates a bufferedImage from image
	    @param image
	    @return bufferedImage
	*/
	private static BufferedImage imageToBufferedImage(Image image)
	{

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
		return bufferedImage;
	}
    
        /** Makes a specific color transparent in a BufferedImage
	    @param im the BufferedImage
	    @param color the color you want to make Transparent
	    @return rgb 
	*/
	private static Image makeColorTransparent(BufferedImage im, final Color color)
	{
		ImageFilter filter = new RGBImageFilter() {

			// the color we are looking for... Alpha bits are set to opaque
			public int markerRGB = color.getRGB() | 0xFF000000;

			public final int filterRGB(int x, int y, int rgb) {
				if ((rgb | 0xFF000000) == markerRGB) {
					// Mark the alpha bits as zero - transparent
					return 0x00FFFFFF & rgb;
				} else {
				// nothing to do
					return rgb;
				}
			}
        	};

		ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}

        /** Returns an image of the tile with the given specifications
	   @param set
	   @param x1
	   @param y1
	   @param x2
	   @param y2
	   @return image
	*/
	public BufferedImage getTile(String set, int x1, int y1, int x2, int y2)
	{
		int w = Math.abs(x2 - x1);
		int h = Math.abs(y2 - y1);
		
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = image.getGraphics();
		
		if(set.equals("TileSet_Main"))
			g.drawImage(TileSet_Main, 0, 0, w, h, x1, y1, x2, y2, null);
		else if(set.equals("TileSet_Characters"))
			g.drawImage(TileSet_Characters, 0, 0, w, h, x1, y1, x2, y2, null);
		else if(set.equals("TileSet_Pkmn"))
		        g.drawImage(TileSet_Pkmn, 0, 0, w, h, x1, y1, x2, y2, null);
		
		return image;
	}

        /** Setter for cameraX and cameraY
	    @param x
	    @param y
	*/
	public void setCameraPos(int x, int y)
	{
		this.cameraX = x;
		this.cameraY = y;
	}
	
        /** Getter for cameraX
	    @return cameraX
	*/
	public int getCameraPosX()
	{
		return this.cameraX;
	}

        /** Getter for cameraY
	    @return cameraY
	*/
        public int getCameraPosY()
	{
		return this.cameraY;
	}
        
        /** Getter for tileWidth
	    @return tileWidth
        */
	public int getTileWidth()
	{
		return tileWidth;
	}

        /** Getter for tileHeight
	    @return tileHeight
	*/
	public int getTileHeight()
	{
		return tileHeight;
	}

    public static void deleteTree(int x, int y) 
    {
		GameGrid g = GameMain.getRenderer().getGameGrid();
		g.setCollisionGrid(GameGrid.GridValue.FREE, x, y);
		g.setCollisionGrid(GameGrid.GridValue.FREE, x, y+1);
		g.setObjectGrid(null, x, y);	        
    }

    private static AudioClip loadSound(String filename) {
		URL fileURL = Renderer.class.getClassLoader().getResource("music/" + filename);
		if(fileURL == null) {
	    	System.out.println("!!!!!!!!!!!");
		}
		return Applet.newAudioClip(fileURL);	
    }
    
    //************************** methods for creating all kinds of buildings ************************************\\

    public void creatPokeball(int x, int y) 
    {
		Building pokeball = new Building(x, y, "POKEBALL");
    }

    public void creatPokeCenter(int x, int y) 
    {
		Building pokeCenter = new Building(x, y, "POKECENTER");creatSmallHouse(55, 35);
    }
    
    public void creatPokeMart(int x, int y) 
    {
		Building pokeMart = new Building(x, y, "POKEMART");
    }
    
    public void creatSmallHouse(int x, int y) 
    {
		Building smallHouse = new Building(x, y, "HOUSE_SMALL_1");
    }

    public void creatTree(int x, int y) 
    {
		Building tree = new Building(x, y, "BASE_TREE_1");
    }
    
    public void creatMediumHouse(int x, int y) 
    {
		Building mediumHouse = new Building(x, y, "HOUSE_MEDIUM_1");
    }
    
    public void creatlargeHouse(int x, int y) 
    {
		Building largeHouse = new Building(x, y, "HOUSE_LARGE_1");
    }
    
    public void creatbigFish(int x, int y) 
    {
		Building bigFish = new Building(x, y, "BIG_FISH");
    }
    
    public void creatdoor(int x, int y) 
    {
		Building door = new Building(x, y, "DOOR");
    }
    
    public void creatBigBuilding(int x, int y) 
    {
		Building bigBuildingLeft = new Building(x, y, "BIG_BUILDING_LEFT");
		Building bigBuildingRight = new Building(x + 8, y, "BIG_BUILDING_RIGHT");
    }
    
    public void creatBigBuilding2(int x, int y) 
    {
		Building bigBuilding2Left = new Building(x, y, "BIG_BUILDING_2_LEFT");
		Building bigBuilding2Right = new Building(x + 8, y, "BIG_BUILDING_2_RIGHT");
    }

    public void creatBigRock(int x, int y) 
    {
		Building bigRock = new Building(x, y, "BIG_ROCK");
    }
    
    public void createWater(int x, int y, int width, int height) 
    {

		// four vertices
		Building water1 = new Building(x, y, "WATER1");
		Building water3 = new Building(x+width, y, "WATER3");
		Building water7 = new Building(x, y+height, "WATER7");
		Building water9 = new Building(x+width, y+height, "WATER9");

		// upper edge and lower edge
		for(int i=x+1; i< x+width; i++) 
		{           
	    	Building water2 = new Building(i, y, "WATER2");
	    	Building water8 = new Building(i, y+height, "WATER8");
		}

		// left edge and right edge
		for(int j=y+1; j< y+height; j++) 
		{           
	    	Building water4 = new Building(x, j, "WATER4");
	    	Building water6 = new Building(x+width, j, "WATER6");
		}

		// fill the middle
		for(int i=x+1; i< x+width; i++) 
		{
	    	for(int j=y+1; j< y+height; j++) 
	    	{
				Building water5 = new Building(i, j, "WATER5");
	    	}
		}	
    }
    
    public void creatRock(int x, int y) 
    {
		Building rock = new Building(x, y, "ROCK1");
    }

    public void createFlower(int x, int y) 
    {
		Building flower = new Building(x, y, "FLOWER");
    }

    public void createFlower2(int x, int y) 
    {
		Building flower2 = new Building(x, y, "FLOWER2");
    }

    public void createNiceTree(int x, int y) 
    {
		Building tree = new Building(x, y, "NICE_TREE_1");
    }

    public void createGod(int x, int y) 
    {
		Building godPokemon = new Building(x, y, "GOD");
    }

    
}
