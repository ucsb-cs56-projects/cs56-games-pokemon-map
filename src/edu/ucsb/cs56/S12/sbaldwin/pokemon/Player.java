package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** The class for the Sprite of type Player. This is the actual character you control, and is a subclass of Character.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/
public class Player extends Character
{
	// Variables

    private boolean onBike;//neither onBike or running currently have any effect on this program
    private boolean running;
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

    private boolean isMoving;
	private boolean moveSwitch;

	private String cm;
	///// Methods

        /** Five arg constructor
	    @param x initial xPos
	    @param y initial yPos
	    @param rotation initial direction to be facing, i.e. NORTH, SOUTH, EAST, WEST
	    @param cm the character model
	    @param name the name of the character
	    @param id the id of the character
	*/
	// Constructor
	public Player(int x, int y, Direction rotation, String cm, String name, int id)
	{
		super(x, y, rotation, name, id);
		onBike = false;
		running = false;
		initializeTexture();
		this.cm = cm;
		GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
		this.updateSpritePosition(x,y);
		this.isMoving = false;
		this.moveSwitch = false;
    }

    /** Method for interacting with the player
    */
	public void interact() {
        // todo
	}

    public void initializeTexture() {
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

    /** Method to move the player
	    @param xOff the horizontal direction the player is moving
	    @param yoff the vertical direction the player is moving
    */
	public void move(int xOff, int yOff) {
	    int prevX = xPos;
	    int prevY = yPos;
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
		    //Here we make Professor Oak turn if his offset is in a direction he isn't facing
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
                isMoving = true;
                }
            GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.BLOCKED, xPos, yPos + 1);
            GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
        }
}
