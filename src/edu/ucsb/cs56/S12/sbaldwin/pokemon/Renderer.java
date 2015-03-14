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

/** The class responsible for deciding what to display to the GamePanel, and loading the buffers.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
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
		gg = new GameGrid(100, 100);

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
		Texture grass_Default = new Texture("GRASS_DEFAULT", "TileSet_Main", 16, 0, 32, 16);
		Texture grass_Wild = new Texture("GRASS_WILD", "TileSet_Main", 0, 16, 16, 32);

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
				//if((counter1 != 45 && counter1 != 46) || (counter2 != 36 && counter2 != 37))
					//if((counter1 != 43 || counter2 != 34) && (counter1 != 48 || counter2 != 39))
						//if((counter1 != 43 || counter2 != 39) && (counter1 != 48 || counter2 != 34))
							gg.setTextureGrid(grass_Wild, counter1, counter2, 0);
			}
		}


		// Load the Buildings
		Building pokeCenter = new PokeCenter(40, 40, 5, 5, true, 1, false);
		Building pokeMart = new PokeMart(45, 41, 4,4, true, 2, false);
		Building smallHouse = new House(55, 35, 5, 3, true, 3, false, "HOUSE_SMALL_1");
		smallHouse = new House(60, 35, 5, 3, true, 4, false, "HOUSE_SMALL_1");
		Building mediumHouse = new House(57, 45, 7, 5, true, 4, false, "HOUSE_MEDIUM_1");
		Building largeHouse = new House(41, 28, 5, 3, true, 5, false, "HOUSE_LARGE_1");

		// Create Trees
		Tree tree;
		for(int counter1 = 0; counter1 < 30; counter1 ++)
		{
			for(int counter2 = 0; counter2 < 30; counter2 ++)
			{
				if(counter1 == 0 || counter1 == 29 || counter2 == 0 || counter2 == 29)
				{
					tree = new Tree(37 + counter1, 25 + counter2, 1, 2, counter1+counter2+6, "BASE_TREE_1");
				}
			}
		}
		tree = new Tree(45, 36, 2, 2, 80, "NICE_TREE_1");
		Tree t = new Tree(52, 40, 4, 8, 90, "EVUL_TREE_1");

		//create Pikachu
		Pikachu pkmn = new Pikachu(44, 45, Character.Direction.STAGNANT, "PIKACHU", "PIKACHU", -1);
		GameMain.gameLogic.registerPkmn(pkmn);

		// Create the player
		Player player = new Player(45, 45, Character.Direction.STAGNANT, "PROFESSOR_OAK", "PROFESSOR_OAK", -2);
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

				Sprite tmp = gg.getObjectGrid(tileX, tileY);
				if(tmp != null)
				{
				    //if(tmp == null) System.exit(0);
				    //try {
                        drawObject(tmp, (tileX - tileXStart), (tileY - tileYStart));
				    //} catch (Exception e) {
                    //   System.out.println("Error...");
				    //}
				}
			}
		}
	}

        /** Draws an object to the buffer
	    @param gObject the Sprite
	    @param tileX the horizontal position
	    @param tileY the vertical position
	*/
	// Helper Object for renderObjectGrid
	private void drawObject(Sprite gObject, int tileX, int tileY)
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
		if(gObject == null) System.exit(-3);
        if(gObject.getTexture() == null) {
            System.out.println(gObject.getClass());
            System.out.println(gObject.getId());
            System.exit(0);
        }
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

}
