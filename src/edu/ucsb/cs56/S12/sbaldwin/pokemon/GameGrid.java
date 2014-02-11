package edu.ucsb.cs56.S12.sbaldwin.pokemon;

public class GameGrid
{
	// Width * height
	
	private GameObject[][] objectGrid;
	private Texture[][][] textureGrid;
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
	
	public GameGrid(int w, int h)
	{
		this.width = w;
		this.height = h;
		
		this.objectGrid = new GameObject[w][h];		
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
	
	// GameGrid
	public GameObject getObjectGrid(int w, int h)
	{
		return this.objectGrid[w][h];
	}
	
	// TextureGrid
	public Texture getTextureGrid(int w, int h, int l)
	{
		return this.textureGrid[w][h][l];
	}
	
	// CollisionGrid
	public GridValue getCollisionGrid(int w, int h)
	{
		return this.collisionGrid[w][h];
	}
	
	
	// Get Width
	public int getWidth()
	{
		return this.width;
	}
	
	// get Height
	public int getHeight()
	{
		return this.height;
	}
	
	
	// Pixel Width
	public int getPixelWidth()
	{
		return this.pixelW;
	}
	
	// Pixel height
	public int getPixelHeight()
	{
		return this.pixelH;
	}
	
	
	///// Setters
	
	// GameGrid
	public void setObjectGrid(GameObject value, int w, int h)
	{
		this.objectGrid[w][h] = value;
	}
	
	// TextureGrid
	public void setTextureGrid(Texture value, int w, int h, int l)
	{
		this.textureGrid[w][h][l] = value;
	}
	
	// CollisionGrid
	public void setCollisionGrid(GridValue value, int w, int h)
	{
		this.collisionGrid[w][h] = value;
	}
}
	
