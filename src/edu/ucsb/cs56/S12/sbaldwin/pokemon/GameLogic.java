package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.awt.event.KeyEvent;

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
	
	
	public GameLogic()
	{
		renderer = GameMain.getRenderer();
		
		playerXPos = 0;
		playerYPos = 0;
		playerXOffset = 0;
		playerYOffset = 0;
	}
	
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
				// System.out.println(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate));
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
	
	public void registerPlayer(Player player)
	{
		this.player = player;
		
		playerXPos = player.getXPos();
		playerYPos = player.getYPos();
	}
	
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
