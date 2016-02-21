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
    private Player pkmn;
	
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

    // points to open the secret path
    private int point = 0;
	
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
				player.move((int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PROFESSOR_OAK", false);
				//For each case when Player.isMoving, have Pikachu continue to walk the way he is facing
				if(pkmn.getXOffset() > 0)
				    {
					pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", false);
				    }
				else if(pkmn.getXOffset() < 0)
				    {
					pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", true);
				    }
				else if(pkmn.getYOffset() > 0)
				    {
					pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
				    }
				else if(pkmn.getYOffset() < 0)
				    {
					pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
				    }
			    }
			else if(player.getXOffset() < 0)
			    {
				player.move((int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PROFESSOR_OAK", false);
				if(pkmn.getXOffset() > 0)
				    {
					pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", true);
				    }
				else if(pkmn.getXOffset() < 0)
				    {
					pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", false);
				    }
				 else if(pkmn.getYOffset() > 0)
				     {
					 pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
				     }
				 else if(pkmn.getYOffset() < 0)
				     {
					 pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
				     }
			    }
			else if(player.getYOffset() > 0)
			    {
				player.move(0, (int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PROFESSOR_OAK", false);
				if(pkmn.getXOffset() > 0)
				    {
					pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", false);
				    }
				else if(pkmn.getXOffset() < 0)
				    {
					pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", false);
				    }
				else if(pkmn.getYOffset() > 0)
				    {
					pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
				    }
				else if(pkmn.getYOffset() < 0)
				    {
					pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", true);
				    }				
			    }
			else if (player.getYOffset() < 0)
			    {
				player.move(0, (int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PROFESSOR_OAK", false);
				if(pkmn.getXOffset() > 0)
				    {
					pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", false);
				    }
				else if(pkmn.getXOffset() < 0)
				    {
					pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", false);
				    }
				else if(pkmn.getYOffset() > 0)
				    {
					pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", true);
				    }
				else if(pkmn.getYOffset() < 0)
				    {
					pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
				    }
			    }
		    }//end of if player is moving

		else 
		    {
			if(rightPressed)
			    {
				player.move((int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PROFESSOR_OAK", false);
				//If player successfully moves, make Pikachu walk into the place that Professor Oak just was
				if(player.isMoving())
				    {
					if(player.getYPos() > pkmn.getYPos())
					    {
						pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
					    }				    
					else if(player.getYPos() < pkmn.getYPos())
					    {
						pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
					    }
					else if(player.getXPos()-pkmn.getXPos() >= 1)
					    {
						pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", false);					
					    }
					else 
					    pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", true);
				    }
			    }
			else if(leftPressed)
			    {
				player.move((int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PROFESSOR_OAK", false);
				if(player.isMoving())
				    {
					if(player.getYPos() > pkmn.getYPos())
					    {
						pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
					    }				    
					else if(player.getYPos() < pkmn.getYPos())
					    {
						pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PIKACHU", false);
					    }
					else if(player.getXPos()-pkmn.getXPos() <= -1)
					    {
						pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", false);					
					    }
					else 
					    pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), 0, "PIKACHU", true);
				    }				
			    }
			else if(upPressed)
			    {
				player.move(0, (int)(-1 * player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PROFESSOR_OAK", false);
				if(player.isMoving())
				    {
					if(player.getXPos() > pkmn.getXPos())
					    {
						pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), 0, "PIKACHU", false);
					    }				    
					else if(player.getXPos() < pkmn.getXPos())
					    {
						pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), 0, "PIKACHU", false);
					    }
					else if(player.getYPos()-pkmn.getYPos() <= -1)
					    {
						pkmn.move(0, (int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), "PIKACHU", false);					
					    }
					else 
					    pkmn.move(0, (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), "PIKACHU", true);
				    }				
			    }
			else if (downPressed)
			    {
				player.move(0, (int)(player.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), "PROFESSOR_OAK", false);
				if(player.isMoving())
				    {
					if(player.getXPos() > pkmn.getXPos())
					    {
						pkmn.move((int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), 0, "PIKACHU", false);
					    }				    
					else if(player.getXPos() < pkmn.getXPos())
					    {
						pkmn.move((int)(-1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileHeight() * 1.0/framerate)), 0, "PIKACHU", false);
					    }
					else if(player.getYPos()-pkmn.getYPos() >= 1)
					    {
						pkmn.move(0, (int)(1 * pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), "PIKACHU", false);					
					    }
					else 
					    pkmn.move(0, -1 * (int)(pkmn.getSpeed() * ((float)GameMain.getRenderer().getTileWidth() * 1.0/framerate)), "PIKACHU", true);
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

			int x1 = 37 + 1;
			int x2 = 37 + 27; 
			int y1 = 26 + 1;
			int y2 = 26 + 27;
			if(playerXPos == x1 || playerYPos == y1 || playerXPos == x2 || playerYPos == y2) {
			    point ++;
			    if(point >= 50 && playerXPos == 64 && playerYPos == 33) {
				openSecretPath();
			    }							    		
			}
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
    
    public void registerPkmn(Player pkmn)
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

    public void openSecretPath() {
	
	GameGrid g = GameMain.getRenderer().getGameGrid();	
	Texture flower = new Texture("flower", "TileSet_Main", 16*0, 16*36, 16*1, 16*37);

	// set collision value to FREE so that we can go through
	g.setCollisionGrid(GameGrid.GridValue.FREE,65,33);
	g.setCollisionGrid(GameGrid.GridValue.FREE,65,34);
	g.setCollisionGrid(GameGrid.GridValue.FREE,65,35);
	g.setCollisionGrid(GameGrid.GridValue.FREE,65,36);
	g.setCollisionGrid(GameGrid.GridValue.FREE,66,35);
	g.setCollisionGrid(GameGrid.GridValue.FREE,66,36);

	// delete the previous trees in order to creat the secret path
	g.setObjectGrid(null,65,33);
	g.setObjectGrid(null,65,34);
	g.setObjectGrid(null,65,35);
	g.setObjectGrid(null,65,36);
	g.setObjectGrid(null,66,35);
	g.setObjectGrid(null,66,36);

	// creat new flowers
	for(int i=32; i<36; i++) {
	    g.setTextureGrid(flower, 64, i, 0);
	}
	g.setTextureGrid(flower, 65, 33, 0);
	g.setTextureGrid(flower, 65, 34, 0);
	g.setTextureGrid(flower, 65, 35, 0);
	g.setTextureGrid(flower, 65, 36, 0);
	g.setTextureGrid(flower, 66, 35, 0);
	g.setTextureGrid(flower, 66, 36, 0);

	/*
	try{
	    Thread.sleep(500);
	} catch(Exception ex) {}
	*/
    }
}
