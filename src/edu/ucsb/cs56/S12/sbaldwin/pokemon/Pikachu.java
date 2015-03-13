package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** class Pikachu is the pokemon that always follows the player around
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/
public class Pikachu extends Character
{
	// Variables
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

        /** 6 arg constructor
	    @param x initial xPos
	    @param y initial yPos
	    @param rotation initial direction to be facing, i.e. NORTH, SOUTH, EAST, WEST
	    @param cm the character model
	    @param name the name of the character
	    @param id the id of the character
	*/
	// Constructor
	public Pikachu(int x, int y, Direction rotation, String cm, String name, int id)
	{
		super(x, y, rotation, name, id);
		this.cm = cm;
		this.setInteractable(false);
		initializeTexture();
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
        //Harvesting the Pikachu sprite from the bitmap with coords (topleftx,toplefty,bottomrightx,bottomrighty),
        //with y coords measured from the top of the bitmap in pixels

        //texture for pikachu facing the top of the screen
        this.front = new Texture(cm, "TileSet_Pkmn", 148, 178, 170, 198); //The pixels where Pikachu is located on the bitmap
        this.front.forceSize(22, 44); //Make sure the sprite fits within 22 pixels by 44 pixels

        this.back = new Texture(cm, "TileSet_Pkmn", 148, 152, 170, 172);
        this.back.forceSize(22, 44);

        this.left = new Texture(cm, "TileSet_Pkmn", 148, 222, 170, 242);
        this.left.forceSize(22, 44);

        this.right = new Texture(cm, "TileSet_Pkmn", 146, 200, 168, 220);
        this.right.forceSize(22, 44);

        //setting texture for one foot forward facing towards the top of the screen
        this.frontMoving1 = new Texture(cm, "TileSet_Pkmn", 170, 178, 192, 198);
        this.frontMoving1.forceSize(22, 44);

        //setting texture for other foot forwards facing towards the top of the screen
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

    /** Method to move the player
	    @param xOff the horizontal direction the player is moving
	    @param yoff the vertical direction the player is moving
    */
	public void move(int xOff, int yOff) {
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
                isMoving = false;
                }
            GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
        }
}

