package edu.ucsb.cs56.S12.sbaldwin.pokemon;


/** The class for objects of type Character.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
*/
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
    private String character1;
	
	private String name;
	
	private boolean isMoving;
	private boolean moveSwitch;
	
	
	///// Methods

        /** Five arg constructor
	    @param x xPos of character
	    @param y yPos of character
	    @param r direction of character
	    @param cm character model
	    @param name name of character
	*/
	// Constructor
	public Character(int x, int y, Direction r, String cm, String name)
	{
		    super(x, y, 1, 2, true);
		
		//Anywhere we see GridValue.BLOCKED, we precede it with a "name != PIKACHU", because we need Pikachu not to have a collision value
		if(name != "PIKACHU")
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

        /** Method to extract the character sprite from the bitmap, currently can only place Professor Oak
	    @param cm character model
	*/
	public void setCharacter(String cm)
	{
		
		
		if(cm == "PIKACHU")
		{
            //Credit to PokeAnayze and celebi23 for the sprites
            this.character1 = cm;
		        //Harvesting the Pikachu sprite from the bitmap
		        this.front = new Texture(cm, "TileSet_Pkmn", 148, 178, 170, 198); //The pixels where Pikachu is located on the bitmap
			this.front.forceSize(22, 44); //Make sure the sprite fits within 20 pixels by 40 pixels
			
			this.back = new Texture(cm, "TileSet_Pkmn", 148, 152, 170, 172);
			this.back.forceSize(22, 44);
			
			this.left = new Texture(cm, "TileSet_Pkmn", 148, 222, 170, 242);
			this.left.forceSize(22, 44);
			
			this.right = new Texture(cm, "TileSet_Pkmn", 146, 200, 168, 220);
			this.right.forceSize(22, 44);
			
			this.frontMoving1 = new Texture(cm, "TileSet_Pkmn", 170, 178, 192, 198);
			this.frontMoving1.forceSize(22, 44);
			
			this.frontMoving2 = new Texture(cm, "TileSet_Pkmn", 126, 178, 148, 198);
			this.frontMoving2.forceSize(22, 44);
			
			this.backMoving1 = new Texture(cm, "TileSet_Pkmn", 126, 152, 148, 172);
			this.backMoving1.forceSize(22, 44);
			
			this.backMoving2 = new Texture(cm, "TileSet_Pkmn", 170, 152, 192, 172);
			this.backMoving2.forceSize(22, 44);
			
			this.leftMoving1 = new Texture(cm, "TileSet_Pkmn", 126, 222, 148, 242);
			this.leftMoving1.forceSize(22, 44);
			
			this.leftMoving2 = new Texture(cm, "TileSet_Pkmn", 170, 222, 192, 242);
			this.leftMoving2.forceSize(22, 44);
			
			this.rightMoving1 = new Texture(cm, "TileSet_Pkmn", 124, 200, 146, 220);
			this.rightMoving1.forceSize(22, 44);
			
			this.rightMoving2 = new Texture(cm, "TileSet_Pkmn", 168, 200, 190, 220);
			this.rightMoving2.forceSize(22, 44);
			
			//Set pikachu to face right
			this.texture = right;
		}
        if(cm == "PROFESSOR_OAK")
        {
            this.character = cm;
            
            this.front = new Texture(cm, "TileSet_Characters", 509, 194, 525, 215); //The pixels where Professor Oak is located on the bitmap
			this.front.forceSize(16, 32); //Make sure the sprite fits within 16 pixels by 32 pixels
			
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
			
			//Set Professor oak to face forward
			this.texture = front;
        }
	}

        /** Method to move the character
	    @param xOff the x offset
	    @param yoff the y offset
	*/
    public void move(int xOff, int yOff, String name, boolean intoOak)
	{
	// Check to see if path is blocked   
	    if(name == "PROFESSOR_OAK")        //Here we make sure only Professor Oak turns if he moves in a way if he isnt facing; we don't want Pikachu to have that feature
        {
            if(xOff > 0)
            {
          
            
                if(GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos + 1, yPos + 1) == GameGrid.GridValue.BLOCKED)
                {
			        //turn right without moving, if blocked
			        this.texture = right;
                    return;
                }
            }
            else if(xOff < 0)
            {
                if(GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos - 1, yPos + 1) == GameGrid.GridValue.BLOCKED)
                {
			        //turn left without moving, if blocked
			        this.texture = left;
			        return;
                }
            }
            else if(yOff > 0)
            {
                if(GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos, yPos + 2) == GameGrid.GridValue.BLOCKED)
                {
			        //turn front without moving, if blocked
			        this.texture = front;
                    return;
                }
            }
            else if(yOff < 0)
            {
			
                if(GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos, yPos) == GameGrid.GridValue.BLOCKED)
                {
			        //turn back without moving, if blocked
			        this.texture = back;
                    return;
                }
            }
            //Here we make Professor Oak turn if he moves in a direction he isn't facing
		    if((xOff > 0) && ((this.texture != right) && (this.texture != rightMoving1) && (this.texture != rightMoving2)))
			{
			    this.texture = right;
			    return;
			}
		    else if((xOff < 0) && ((this.texture != left) && (this.texture != leftMoving1) && (this.texture != leftMoving2)))
			{
			    this.texture = left;
			    return;
			}
		    else if((yOff > 0) && ((this.texture != front) && (this.texture != frontMoving1) && (this.texture != frontMoving2)))
			{
			    this.texture = front;
			    return;
			}
		    else if((yOff < 0) && ((this.texture != back) && (this.texture != backMoving1) && (this.texture != backMoving2)))
			{
			    this.texture = back; 
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
		    //If Pikachu is moving into Oak, we don't want Pikachu to delete Oak's object grid
		if(intoOak == false)
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
		    if(intoOak == false)
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
		if(intoOak == false)
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
		if(intoOak == false)
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
		if(name == "PROFESSOR_OAK")
		GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.BLOCKED, xPos, yPos + 1);
		this.updatePos();
	}
                                            
   	// Getters

        /** Getter for rotation
	    @return rotation the direction the character is facing, i.e. NORTH, SOUTH, EAST, WEST
	*/
	public Direction getRotation()
	{
		return rotation;
	}

       /** Getter for character
	   @return character
       */
	public String getCharacter()
	{
		return character;
	}

        /** Getter for name
	    @return name name of character
	*/
	public String getName()
	{
		return name;
	}

        /** Getter for speed
	    @return speed, how fast the character moves
	*/	
	public int getSpeed()
	{
		return this.speed;
	}
	
	// Setters

        /** Setter for xPos
	    @param xPos x position of character
	*/
	public void setXPos(int x)
	{
		this.xPos = x;
	}

        /** Setter for yPos
	    @param yPos y position of character
	*/	
	public void setYPos(int y)
	{
		this.yPos = y;
	}

        /** Setter for rotation
	    @param rotation direction character is facing i.e. NORTH, SOUTH, EAST, WEST
	*/	
	public void setRotation(Direction r)
	{
		this.rotation = r;
	}
    
        /** Setter for name
	    @param name name of character
	*/
	public void setName(String name)
	{
		this.name = name;
	}

        /** Setter for speed
	    @param speed how fast the character moves
	*/
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

        /** Getter for isMoving
	    @return isMoving determines if the character is moving
	*/	
	public boolean isMoving()
	{
		return isMoving;
	}

        /** Setter for isMoving
	    @param isMoving a boolean to indicate whether the character is moving
	*/
	public void setMoving(boolean value)
	{
		this.isMoving = value;
	}
}
