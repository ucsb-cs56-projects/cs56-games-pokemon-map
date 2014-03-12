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
	
	// Player positioning
	private int playerXPos;
	private int playerYPos;
	private int playerXOffset;
	private int playerYOffset;
	
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
			}
			else if(player.getXOffset() < 0)
			{
				player.move((int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
			}
			else if(player.getYOffset() > 0)
			{
				player.move(0, (int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
			}
			else if (player.getYOffset() < 0)
			{
				player.move(0, (int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
			}
		}
		else
		{
			if(rightPressed)
			{
			    player.move((int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
			}
			else if(leftPressed)
			{
			    player.move((int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0);
			}
			else if(upPressed)
			{
			    player.move(0, (int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
			}
			else if (downPressed)
			{
			    player.move(0, (int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)));
			}
		}
				
	
		// Update position
		if(player != null)
		{
			playerXPos = player.getXPos();
			playerYPos = player.getYPos();
			playerXOffset = player.getXOffset();
			playerYOffset = player.getYOffset();
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

        /** Indicates when a key has been pressed
	    @param e KeyEvent
	*/
	public void sendKeyPressed(KeyEvent e)
	{
	    //Here we try to fix the turning issue by introducing sleep. Whereas normally you would have to tap the button
	    //extremely quickly in order to only turn, now it is a bit easier to turn, because it takes a bit longer for 
	    //the system to sense the button is still being pressed. A pretty crude solution, but a cleaner solution 
	    //requires serious refactoring in registering the button presses.
	    try{
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
		{
			upPressed = true;
			Thread.sleep(10);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			downPressed = true;
			Thread.sleep(10);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			leftPressed = true;
			Thread.sleep(10);

		}
		
		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rightPressed = true;
			Thread.sleep(10);
		}
	    } catch(Exception ex){}
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
