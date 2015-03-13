package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.awt.event.KeyEvent;

/** GameLogic tells the program when to do what when a key is pressed.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
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
	}

        /** If the player isMoving, update game moves the character and renders the next frame. Otherwise, updateGame listens for a key to be pressed, and indicates the character to move
	 */
        public void updateGame()
	{
		// Move player
		if(player.isMoving())
		    {
			if(player.getXOffset() > 0)
			    {
				player.move((int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				//For each case when Player.isMoving, have Pikachu continue to walk the way he is facing
				if(pkmn.getXOffset() > 0)
				    {
					pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
				else if(pkmn.getXOffset() < 0)
				    {
					pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
				else if(pkmn.getYOffset() > 0)
				    {
					pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				    }
				else if(pkmn.getYOffset() < 0)
				    {
					pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				    }
			    }
			else if(player.getXOffset() < 0)
			    {
				player.move((int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				if(pkmn.getXOffset() > 0)
				    {
					pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
				else if(pkmn.getXOffset() < 0)
				    {
					pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
				 else if(pkmn.getYOffset() > 0)
				     {
					 pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				     }
				 else if(pkmn.getYOffset() < 0)
				     {
					 pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				     }
			    }
			else if(player.getYOffset() > 0)
			    {
				player.move(0, (int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				if(pkmn.getXOffset() > 0)
				    {
					pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
				else if(pkmn.getXOffset() < 0)
				    {
					pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
				else if(pkmn.getYOffset() > 0)
				    {
					pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				    }
				else if(pkmn.getYOffset() < 0)
				    {
					pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				    }
			    }
			else if (player.getYOffset() < 0)
			    {
				player.move(0, (int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				if(pkmn.getXOffset() > 0)
				    {
					pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
				else if(pkmn.getXOffset() < 0)
				    {
					pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
				else if(pkmn.getYOffset() > 0)
				    {
					pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				    }
				else if(pkmn.getYOffset() < 0)
				    {
					pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				    }
			    }
		    }//end of if player is moving

		else
		    {
			if(rightPressed)
			    {
				player.move((int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				//If player successfully moves, make Pikachu walk into the place that Professor Oak just was
				if(player.isMoving())
				    {
                    System.out.println("NOT HERE!?");
					if(player.getYPos() > pkmn.getYPos())
					    {
                        System.out.println("1");
						pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
					    }
					else if(player.getYPos() < pkmn.getYPos())
					    {
					        System.out.println("2");
						pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
					    }
					else if(player.getXPos()-pkmn.getXPos() >= 1)
					    {
					        System.out.println("3");
						pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
					    }
					else
                        System.out.println("4");
					    pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
			    }
			else if(leftPressed)
			    {
			        System.out.println("LEFT");
				player.move((int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				if(player.isMoving())
				    {
					if(player.getYPos() > pkmn.getYPos())
					    {
						pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
					    }
					else if(player.getYPos() < pkmn.getYPos())
					    {
						pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
					    }
					else if(player.getXPos()-pkmn.getXPos() <= -1)
					    {
						pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
					    }
					else
					    pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
				    }
			    }
			else if(upPressed)
			    {
				player.move(0, (int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				if(player.isMoving())
				    {
					if(player.getXPos() > pkmn.getXPos())
					    {
						pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), 0);
					    }
					else if(player.getXPos() < pkmn.getXPos())
					    {
						pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), 0);
					    }
					else if(player.getYPos()-pkmn.getYPos() <= -1)
					    {
						pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)));
					    }
					else
					    pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)));
				    }
			    }
			else if (downPressed)
			    {
				player.move(0, (int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
				if(player.isMoving())
				    {
					if(player.getXPos() > pkmn.getXPos())
					    {
						pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), 0);
					    }
					else if(player.getXPos() < pkmn.getXPos())
					    {
						pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), 0);
					    }
					else if(player.getYPos()-pkmn.getYPos() >= 1)
					    {
						pkmn.move(0, (int)(1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)));
					    }
					else
					    pkmn.move(0, -1 * (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)));
				    }
			    }
		    }//ends the else, meaning if the player is not moving



		// Update position
		if(player != null)
		    {
			playerXPos = player.getXPos();
			playerYPos = player.getYPos();
			playerXOffset = player.getXOffset();
			playerYOffset = player.getYOffset();

		    }
		//Update Pikachu's position
		if(pkmn != null)
		    {
			pkmnXPos = pkmn.getXPos();
			pkmnYPos = pkmn.getYPos();
			pkmnXOffset = pkmn.getXOffset();
			pkmnYOffset = pkmn.getYOffset();
		    }
	}//end of update game

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
	}
}
