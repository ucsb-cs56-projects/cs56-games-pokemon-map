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

    //private boolean moving;
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
		this.moveSwitch = false;
		collisionValue[0][0] = GameGrid.GridValue.FREE;
		collisionValue[0][1] = GameGrid.GridValue.BLOCKED;
    }

    /** Rotate orientation based on movement
        @param current orientation of player
        @param moving moving uses a different texture
    */
    public void rotateView(Direction o, boolean moving) {
        switch(o) {
        	case NORTH:
        		this.texture = moving ? frontMoving1 : front;
        		break;
        	case SOUTH:
        		this.texture = moving ? backMoving1 : back;
        		break;
        	case EAST:
        		this.texture = moving ? rightMoving1 : right;
        		break;
        	case WEST:
        		this.texture = moving ? leftMoving1 : left;
        		break;
        }
        setOrientation(o);
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
    	if(xPos + xOff >= GameMain.SIZE || yPos + yOff >= GameMain.SIZE) {
    		isMoving = false;
    		rotateView(orientation, false);
    		return;
    	}
		//if next step is blocked, don't do anything
    	if((xOff > 0 && GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos + 1, yPos + 1) == GameGrid.GridValue.BLOCKED) ||
    		(yOff > 0 && GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos, yPos+2) == GameGrid.GridValue.BLOCKED) ||
    		(xOff < 0 && GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos-1, yPos) == GameGrid.GridValue.BLOCKED) ||
    		(yOff < 0 && GameMain.getRenderer().getGameGrid().getCollisionGrid(xPos, yPos-1) == GameGrid.GridValue.BLOCKED)) 	{
    		return;
  		}
    	isMoving = true;
    	// free up the current spot in every grid
    	
    	this.xOffset += xOff;
        this.yOffset += yOff;
    	int tileWidth = GameMain.getRenderer().getTileWidth();
        int tileHeight = GameMain.getRenderer().getTileHeight();
        // only continue on to update positions if the threshold has been reached
        if(Math.abs(this.xOffset) >= tileWidth) {
        	GameMain.getRenderer().getGameGrid().setObjectGrid(null, xPos, yPos);
        	GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.FREE,xPos, yPos+1);
        	xPos += (this.xOffset / tileWidth);
        	this.xOffset = 0;
        } else if(Math.abs(this.yOffset) >= tileHeight) {
        	GameMain.getRenderer().getGameGrid().setObjectGrid(null, xPos, yPos);
        	GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.FREE,xPos, yPos+1);
        	yPos += (this.yOffset / tileHeight);
        	this.yOffset = 0;
        }
        if(xOffset == 0 && yOffset == 0) {
        	isMoving = false;
        }
        // update grids with new data
        GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
    	GameMain.getRenderer().getGameGrid().setCollisionGrid(GameGrid.GridValue.BLOCKED, xPos, yPos+1);
        rotateView(orientation, isMoving);
    }
    
    /** Setter for running
    	@param value true if running, false otherwise
    */
    public void setRunning(boolean value) {
    	running = value;
    }
    
    /** Getter for running
    	@return true if running, false otherwise
    */
    public boolean isRunning() {
    	return running;
    }
}

