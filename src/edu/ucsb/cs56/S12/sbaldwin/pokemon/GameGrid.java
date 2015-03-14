package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** The class to hold and interact with the Collision, Texture and Object values at each point in the grid
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/

public class GameGrid
{
	// Width * height

	private Sprite[][] objectGrid;
        private Texture[][][] textureGrid; //Third array of texture grid will always have length 3
	private GridValue[][] collisionGrid;

	private final static int pixelW = 16;
	private final static int pixelH = 16;

	int width;
	int height;

	// possible values

	public static enum GridValue
	{
		///// CollisionGrid values

		BLOCKED, FREE, OPEN_NORTH, OPEN_SOUTH, OPEN_WEST, OPEN_EAST
	}





	////////////////////////////////////   Methods   ///////////////////////////////////

	// Constructor

        /** Two arg constructor
	    @param w width of GameGrid
	    @param h height of GameGrid
	*/
	public GameGrid(int w, int h)
	{
		this.width = w;
		this.height = h;

		this.objectGrid = new Sprite[w][h];
		this.collisionGrid = new GridValue[w][h];
		this.textureGrid = new Texture[w][h][2];

		// Initialize value
		for(int counter1 = 0; counter1 < w; counter1 ++)
		{
			for(int counter2 = 0; counter2 < h; counter2 ++)
			{
				this.objectGrid[counter1][counter2] = null;
				this.collisionGrid[counter1][counter2] = GridValue.FREE;
				this.textureGrid[counter1][counter2][0] = null;
				this.textureGrid[counter1][counter2][1] = null;
			}
		}
	}

	///// Getters

        /** Returns the Sprite at (w,h)
	    @param w horizontal position
	    @param h vertical position
	*/
	// GameGrid
	public Sprite getObjectGrid(int w, int h)
	{
		return this.objectGrid[w][h];
	}


        /** Returns the Texture at (w,h,l)
	    @param w horizontal position
	    @param h vertical position
	    @param l
	*/
	// TextureGrid
	public Texture getTextureGrid(int w, int h, int l)
	{
		return this.textureGrid[w][h][l];
	}


        /**  Returns the collision value at point w,h
	     @param w
	     @param h
	     @return GridValue
	*/
	// CollisionGrid
	public GridValue getCollisionGrid(int w, int h)
	{
		return this.collisionGrid[w][h];
	}


        /**  Getter for width
	     @return width
	*/
	// Get Width
	public int getWidth()
	{
		return this.width;
	}


        /** Getter for height
	    @return height
	*/
	// get Height
	public int getHeight()
	{
		return this.height;
	}


        /** Getter for pixel width
	    @return pixelW
	*/
	// Pixel Width
	public int getPixelWidth()
	{
		return this.pixelW;
	}


        /** Getter for pixel height
	    @return pixelH
	*/
	// Pixel height
	public int getPixelHeight()
	{
		return this.pixelH;
	}


	///// Setters

        /** Setter for the ObjectGrid at point w,h
	    @param value
	    @param w
	    @param h
	*/
	// GameGrid
	public void setObjectGrid(Sprite value, int w, int h)
	{
		this.objectGrid[w][h] = value;
	}


        /** Setter for the TextureGrid at point w,h
	    @param value
	    @param w
	    @param h
	    @param l
	*/
	// TextureGrid
	public void setTextureGrid(Texture value, int w, int h, int l)
	{
		this.textureGrid[w][h][l] = value;
	}


        /** Setter for the Collision grid at w,h
	    @param value
	    @param w
	    @param h
	*/
	// CollisionGrid
	public void setCollisionGrid(GridValue value, int w, int h)
	{
		this.collisionGrid[w][h] = value;
	}
}

