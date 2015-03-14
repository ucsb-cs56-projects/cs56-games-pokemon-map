package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.awt.event.KeyEvent;

/** GameLogic tells the program when to do what when a key is pressed.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/
public class GameLogic
{
    private Player player;
    private Pikachu pkmn;

    // Player positioning
    private int playerXPos;
    private int playerYPos;
    private int playerXOffset;
    private int playerYOffset;
    private double xStep;
    private double yStep;
    private double threshold;
    
    private int xLeft;
    private int xRight;
    private int yUp;
    private int yDown;

    //Pkmn positioning
    private int pkmnXPos;
    private int pkmnYPos;
    private int pkmnXOffset;
    private int pkmnYOffset;

    // Input
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;

    // Time management
    private long startTime = 0;
    private long elapsedTime = 0;
    private long framerate;

    Renderer renderer;


    /** No arg constructor
     */
    public GameLogic()
    {
		renderer = GameMain.getRenderer();

		playerXPos = 0;
		playerYPos = 0;
		playerXOffset = 0;
		playerYOffset = 0;

		pkmnXPos = -1;
		pkmnYPos = 0;
		pkmnXOffset = 0;
		pkmnYOffset = 0;

		xStep = 0.0;
		yStep = 0.0;
		threshold = GameMain.getRenderer().getTileWidth();
    }

    public void updateGame() {
    	// slight boost in speed when running
    	if(player.isRunning()) player.setSpeed(7);
    	else player.setSpeed(5);
    	if(pkmn.isRunning()) pkmn.setSpeed(7);
    	else pkmn.setSpeed(5);
    	int xLeft = (int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate));
    	int xRight = (int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate));
    	int yUp = (int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate));
    	int yDown = (int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate));
    	
    	// continue moving in same direction
    	if(player.isMoving()) {
    		switch(player.getOrientation()) {
				case NORTH:
					player.move(0,yDown);
					pkmn.move(0,yDown);
					break;
				case SOUTH:
					player.move(0,yUp);
					pkmn.move(0,yUp);
					break;
				case EAST:
					player.move(xRight,0);
					pkmn.move(xRight,0);
					break;
				case WEST:
					player.move(xLeft,0);
					pkmn.move(xLeft,0);
					break;
			}
    	}
		else if(upPressed) {
			// make sure we're facing SOUTH when upPressed
			if(player.getOrientation() != Character.Direction.SOUTH) {
				player.rotateView(Character.Direction.SOUTH, player.isMoving());
			}
			if(pkmn.getOrientation() != Character.Direction.SOUTH) {
				pkmn.rotateView(Character.Direction.SOUTH, pkmn.isMoving());
			}
			// move pikachu around the professor and follow
			player.move(0,yUp);
			if(player.isMoving()) {
				if(player.getXPos() > pkmn.getXPos()) {
					pkmn.move(xRight,0);
				} else if(player.getXPos() < pkmn.getXPos()) {
					pkmn.move(xLeft,0);
				} else if(player.getYPos()-pkmn.getYPos() <= -1) {
					pkmn.move(0,yUp);
				} else {
					pkmn.move(0,yDown);
				}
			}
		}
		else if(downPressed) {
			// make sure we're facing NORTH when downPressed
			if(player.getOrientation() != Character.Direction.NORTH) {
				player.rotateView(Character.Direction.NORTH, player.isMoving());
			}
			if(pkmn.getOrientation() != Character.Direction.NORTH) {
				pkmn.rotateView(Character.Direction.NORTH, pkmn.isMoving());
			}
			player.move(0,yDown);
			if(player.isMoving()) {
				// move pikachu around the professor and follow
				
				if(player.getXPos() > pkmn.getXPos()) {
					pkmn.move(xRight,0);
				} else if(player.getXPos() < pkmn.getXPos()) {
					pkmn.move(xLeft,0);
				} else if(player.getYPos()-pkmn.getYPos() <= -1) {
					pkmn.move(0,yUp);
				} else {
					pkmn.move(0,yDown);
				}
			}
		}
		else if(leftPressed) {
			// make sure we're facing west when leftPressed
			if(player.getOrientation() != Character.Direction.WEST) {
				player.rotateView(Character.Direction.WEST, player.isMoving());
			}
			if(pkmn.getOrientation() != Character.Direction.WEST) {
				pkmn.rotateView(Character.Direction.WEST, pkmn.isMoving());
			}
			player.move(xLeft,0);
			if(player.isMoving()) {
				// move pikachu around the professor and follow
				
				if(player.getYPos() > pkmn.getYPos()) {
					pkmn.move(0,yDown);
				} else if(player.getYPos() < pkmn.getYPos()) {
					pkmn.move(0,yUp);
				} else if(player.getXPos()-pkmn.getXPos() >= 1) {
					pkmn.move(xLeft,0);
				} else {
					pkmn.move(xRight,0);
				}
			}
		}
		else if(rightPressed) {
			// make sure we're facing east when rightPressed
			if(player.getOrientation() != Character.Direction.EAST) {
				player.rotateView(Character.Direction.EAST, player.isMoving());
			}
			if(pkmn.getOrientation() != Character.Direction.EAST) {
				pkmn.rotateView(Character.Direction.EAST, pkmn.isMoving());
			}
			player.move(xRight,0);
			if(player.isMoving()) {
				// move pikachu around the professor and follow
				
				if(player.getYPos() > pkmn.getYPos()) {
					pkmn.move(0,yDown);
				} else if(player.getYPos() < pkmn.getYPos()) {
					pkmn.move(0,yUp);
				} else if(player.getXPos()-pkmn.getXPos() >= 1) {
					pkmn.move(xRight,0);
				} else {
					pkmn.move(xLeft,0);
				}
			}
		}
		// update player position
		if(player != null) {
			playerXOffset = player.getXOffset();
			playerYOffset = player.getYOffset();
			playerXPos = player.getXPos();
			playerYPos = player.getYPos();
		}
		// update pikachu position
		if(pkmn != null) {
			pkmnXOffset = pkmn.getXOffset();
			pkmnYOffset = pkmn.getYOffset();
			pkmnXPos = pkmn.getXPos();
			pkmnYPos = pkmn.getYPos();
		}
	}

        /** Prepares the next frame
	 */
	public void renderNextFrame()
	{
		// Update the clock
		elapsedTime = System.nanoTime() - startTime;
		if(elapsedTime < 0)
			elapsedTime = 0;

		// Compute framerate
		framerate = (1000000000/elapsedTime);
		// System.out.println("Framerate = " + framerate);

		startTime = System.nanoTime();

		// Update the game data
		this.updateGame();

		// Reset the buffer
		renderer.clearBuffer();

		// Render the Grids to Buffer Image
		renderer.renderTextureGrid(playerXPos - 15, playerYPos - 15, playerXPos + 15, playerYPos + 15);
		renderer.renderObjectGrid(playerXPos - 15, playerYPos - 15, playerXPos + 15, playerYPos + 15);

		// Draw actual Image from Buffer Image
		renderer.drawFinalImage(5, 5, playerXOffset+56, playerYOffset+56, 25, 25);
                //original values are 3,3,25,25
		//<<MOVED THE OFFSET
	}
        /** Registers the player into the game
	    @param player
	*/
	public void registerPlayer(Player player)
	{
		this.player = player;

		playerXPos = player.getXPos();
		playerYPos = player.getYPos();
	}

    public void registerPkmn(Pikachu pkmn)
    {
        this.pkmn = pkmn;

        pkmnXPos = pkmn.getXPos();
        pkmnYPos = pkmn.getYPos();

    }

        /** Indicates when a key has been pressed
	    @param e KeyEvent
	*/
	public void sendKeyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
		{
			upPressed = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			downPressed = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed = true;

		}

		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			if(player != null) player.setRunning(true);
			if(pkmn != null) pkmn.setRunning(true);
		}
	}

        /** Indicates when a key has been released
	    @param e KeyEvent
	*/
	public void sendKeyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
		{
			upPressed = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)

	{
			downPressed = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_R) {
			if(player != null) player.setRunning(false);
			if(pkmn != null) pkmn.setRunning(false);
		}
	}
}
