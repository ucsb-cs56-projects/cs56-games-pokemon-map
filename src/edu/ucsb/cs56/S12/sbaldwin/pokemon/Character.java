package edu.ucsb.cs56.S12.sbaldwin.pokemon;

public class Character extends GameObject
{
	///// Variables

	public static enum Direction
	{
		NORTH, SOUTH, WEST, EAST
	}
	
	public static enum CharacterModel
	{
		PLAYER_DEFAULT_MALE, PLAYER_DEFAULT_FAMALE	
	}

	private int speed;    // Measured in pixels
	private Direction rotation;
	
	// All the angles for textures
	private Texture front;
	private Texture frontMoving1;
	private Texture frontMoving2;
	private Texture back;
	private Texture backMoving1;
	private Texture backMoving2;
	private Texture left;
	private Texture leftMoving1;
	private Texture leftMoving2;
	private Texture right;
	private Texture rightMoving1;
	private Texture rightMoving2;
	
	private String character;
	
	private String name;
	
	private boolean isMoving;
	private boolean moveSwitch;
	
	
	///// Methods
	
	// Constructor
	public Character(int x, int y, Direction r, String cm, String name)
	{
		super(x, y, 1, 2, true);
		collisionValue[0][1] = GameGrid.GridValue.BLOCKED;
		
		this.xOffset = 0;
		this.yOffset = 0;
		
		this.speed =  5;      // Default speed - measured in tiles per second
		
		this.rotation = r;
		this.setCharacter(cm);
		this.name = name;
		
		this.isMoving = false;
		this.moveSwitch = false;
	}
	
	public void setCharacter(String cm)
	{
		this.character = cm;
		
		if(cm == "PROFESSOR_OAK")
		{
			this.front = new Texture(cm, "TileSet_Characters", 509, 194, 525, 215);
			this.front.forceSize(16, 32);
			
			this.back = new Texture(cm, "TileSet_Characters", 524, 194, 540, 215);
			this.back.forceSize(16, 32);
			
			this.left = new Texture(cm, "TileSet_Characters", 539, 194, 554, 215);
			this.left.forceSize(16, 32);
			
			this.right = new Texture(cm, "TileSet_Characters", 554, 194, 539, 215);
			this.right.forceSize(16, 32);
			
			this.frontMoving1 = new Texture(cm, "TileSet_Characters", 554, 194, 570, 215);
			this.frontMoving1.forceSize(16, 32);
			
			this.frontMoving2 = new Texture(cm, "TileSet_Characters", 570, 194, 554, 215);
			this.frontMoving2.forceSize(16, 32);
			
			this.backMoving1 = new Texture(cm, "TileSet_Characters", 569, 194, 585, 215);
			this.backMoving1.forceSize(16, 32);
			
			this.backMoving2 = new Texture(cm, "TileSet_Characters", 585, 194, 569, 215);
			this.backMoving2.forceSize(16, 32);
			
			this.leftMoving1 = new Texture(cm, "TileSet_Characters", 584, 194, 599, 215);
			this.leftMoving1.forceSize(16, 32);
			
			this.leftMoving2 = new Texture(cm, "TileSet_Characters", 598, 194, 613, 215);
			this.leftMoving2.forceSize(16, 32);
			
			this.rightMoving1 = new Texture(cm, "TileSet_Characters", 599, 194, 584, 215);
			this.rightMoving1.forceSize(16, 32);
			
			this.rightMoving2 = new Texture(cm, "TileSet_Characters", 613, 194, 598, 215);
			this.rightMoving2.forceSize(16, 32);
			
			this.texture = front;
		}
	}
	
	public void move(int xOff, int yOff)
	{
		// Check to see if path is blocked
		if(xOff > 0)
		{
			if(GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos + 1, yPos + 1) == GameGrid.GridValue.BLOCKED)
			{
				return;
			}
		}
		else if(xOff < 0)
		{
			if(GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos - 1, yPos + 1) == GameGrid.GridValue.BLOCKED)
			{
				return;
			}
		}
		else if(yOff > 0)
		{
			if(GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos, yPos + 2) == GameGrid.GridValue.BLOCKED)
			{
				return;
			}
		}
		else if(yOff < 0)
		{
			
			if(GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos, yPos) == GameGrid.GridValue.BLOCKED)
			{
				return;
			}
		}
	
		///// Move offset
		this.xOffset += xOff;
		this.yOffset += yOff;
		
		// Update character image
		if(xOffset > 0)
		{
			if(xOffset < 5 || xOffset > 25)
			{
				this.texture = right;
			}
			else if(moveSwitch)
			{
				this.texture = rightMoving1;
			}
			else
			{
				this.texture = rightMoving2;
			}
		}
		else if(xOffset < 0)
		{
			if(xOffset > -5 || xOffset < -25)
			{
				this.texture = left;
			}
			else if(moveSwitch)
			{
				this.texture = leftMoving1;
			}
			else
			{
				this.texture = leftMoving2;
			}
		}
		else if(yOffset > 0)
		{
			if(yOffset < 5 || yOffset > 25)
			{
				this.texture = front;
			}
			else if(moveSwitch)
			{
				this.texture = frontMoving1;
			}
			else
			{
				this.texture = frontMoving2;
			}
		}
		else if(yOffset < 0)
		{
			if(yOffset > -5 || yOffset < -25)
			{
				this.texture = back;
			}
			else if(moveSwitch)
			{
				this.texture = backMoving1;
			}
			else
			{
				this.texture = backMoving2;
			}
		}			
		
		// Update isMoving variable
		isMoving = true;
		
		
		///// If offset is >= GridPixelSize reset offset and move character
		
		int tileWidth = GameMain.getRenderer().getTileWidth();
		int tileHeight = GameMain.getRenderer().getTileHeight();
		
		if(xOffset >= tileWidth)
		{
			// Delete previous position data
			GameMain.getRenderer().getGameGrid().setObjectGrid(null, xPos, yPos);
			GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.FREE,
										     xPos, yPos + 1);
			
			xPos += xOffset / tileWidth;
			xOffset = 0;
			
			// Update character image and moveSwitch
			this.texture = right;
			this.moveSwitch = !moveSwitch;
		}
		else if(xOffset <= (-1 * tileWidth))
		{
			// Delete previous position data
			GameMain.getRenderer().getGameGrid().setObjectGrid(null, xPos, yPos);
			GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.FREE,
										     xPos, yPos + 1);
			
			xPos -= xOffset / (-1 * tileWidth);
			xOffset = 0;
			
			// Update character image
			this.texture = left;
			this.moveSwitch = !moveSwitch;
		}
		
		if(yOffset >= tileHeight)
		{
			// Delete previous position data
			GameMain.getRenderer().getGameGrid().setObjectGrid(null, xPos, yPos);
			GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.FREE,
										     xPos, yPos + 1);
			
			yPos += yOffset / tileHeight;
			yOffset = 0;
			
			// Update character image
			this.texture = front;
			this.moveSwitch = !moveSwitch;
		}
		else if(yOffset <= (-1 * tileHeight))
		{
			// Delete previous position data
			GameMain.getRenderer().getGameGrid().setObjectGrid(null, xPos, yPos);
			GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.FREE,
										     xPos, yPos + 1);
			
			yPos -= yOffset / (-1 * tileHeight);
			yOffset = 0;
			
			// Update character image
			this.texture = back;
			this.moveSwitch = !moveSwitch;
		}
		
		if(xOffset == 0 && yOffset == 0)
		{
			isMoving = false;
		}
		
		// Update current position to grid
		GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.BLOCKED, xPos, yPos + 1);
		this.updatePos();
	}
		
	
	// Getters
	
	public Direction getRotation()
	{
		return rotation;
	}
	
	public String getCharacter()
	{
		return character;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	// Setters
	
	public void setXPos(int x)
	{
		this.xPos = x;
	}
	
	public void setYPos(int y)
	{
		this.yPos = y;
	}
	
	public void setRotation(Direction r)
	{
		this.rotation = r;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public boolean isMoving()
	{
		return isMoving;
	}
	
	public void setMoving(boolean value)
	{
		this.isMoving = value;
	}
}
