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

    // indication of the game stage
    private boolean ableToOpenLastPath;
    private boolean long1AlreadyPlayed;
    private boolean long2AlreadyPlayed;
    private boolean long3AlreadyPlayed;
    private boolean long4AlreadyPlayed;
    private boolean long5AlreadyPlayed;
    private boolean long6AlreadyPlayed;
    private boolean long7AlreadyPlayed;
    private boolean short3AlreadyPlayed;
	
    Renderer renderer;
    GameGrid g = GameMain.getRenderer().getGameGrid();
    Renderer r = GameMain.getRenderer();
	
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

			if(GameMain.getRenderer().getGameGrid().getTextureGrid(playerXPos, playerYPos, 0).getName() == "flower") {
			    point ++;
			    if(playerXPos == 64 && playerYPos == 33 && point >= 500 ) {
				openSecretPath();
			    }							    		
			}

			if(((playerXPos == 95 && playerYPos == 40) || (playerXPos == 95 && playerYPos == 39))
			    && (GameMain.getRenderer().getGameGrid().getTextureGrid(playerXPos, playerYPos, 0).getName() != "flower2")) {
			    creatFlowers();
			}

			if(playerXPos == 147 && playerYPos == 28) {
			   // when go into the big fish mouse, open secret path 2
			   openSecretPath2();
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

		if(e.getKeyCode() == KeyEvent.VK_H)
		{
		    
		    if(playerXPos == 41 && playerYPos == 97) 
		    {
				openSecretPath3();
		    }

		    if((playerXPos == 57 && playerYPos == 32) ||
		       (playerXPos == 58 && playerYPos == 32) ||
		       (playerXPos == 59 && playerYPos == 32) )
		    {
			 	
			 	openSecretPath4();
		    
		    }

		    if(playerXPos == 71 && playerYPos == 81 && ableToOpenLastPath) 
		    {
			 	openSecretPath5();
		    }

		    if((playerXPos > 77 && playerXPos < 82)&& playerYPos == 35) {
				// talking to the big pokemon in the forest is the last event in the story
				openSecretPath6();
		    }
		}
		
		if(e.getKeyCode() == KeyEvent.VK_M) 
		{
		    printPosition();
		}

		// this has some bugs
		/*
		if(e.getKeyCode() == KeyEvent.VK_J) {
		    changeSpeed();
		}
		*/

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

    public void printPosition() 
    {
		System.out.print("(" + playerXPos + "," + playerYPos + ")");
    }

    public void openSecretPath() 
    {
		// change background music
		if(long2AlreadyPlayed == false) {
	    	Renderer.long1.stop();
	    	Renderer.long2.play();
	    	long2AlreadyPlayed = true;
		}
	
		GameGrid g = GameMain.getRenderer().getGameGrid();
		Texture flower = new Texture("flower", "TileSet_Main", 16*0, 16*36, 16*1, 16*37);

		// delete the previous trees in order to creat the secret path
		Renderer.deleteTree(65,33);
		Renderer.deleteTree(65,34);
		Renderer.deleteTree(65,35);
		Renderer.deleteTree(65,36);
		Renderer.deleteTree(66,35);
		Renderer.deleteTree(66,36);

		// create new flowers
		for(int i = 32; i < 36; i++)
		{
	    	g.setTextureGrid(flower, 64, i, 0);
		}
		g.setTextureGrid(flower, 65, 33, 0);
		g.setTextureGrid(flower, 65, 34, 0);
		g.setTextureGrid(flower, 65, 35, 0);
		g.setTextureGrid(flower, 65, 36, 0);
		g.setTextureGrid(flower, 66, 35, 0);
		g.setTextureGrid(flower, 66, 36, 0);
	
		// continue the path...
		for(int y=36; y<41; y++) 
		{
	    	Renderer.deleteTree(66,y);
	    	g.setTextureGrid(flower, 66, y, 0);
		}

		for(int x=66; x<95; x++) 
		{
	    	Renderer.deleteTree(x,39);
	    	Renderer.deleteTree(x,40);
	    	Renderer.deleteTree(x,41);
	    	g.setTextureGrid(flower, x, 39, 0);	    
	    	g.setTextureGrid(flower, x, 40, 0);
	    	g.setTextureGrid(flower, x, 41, 0);
		}
	
	/*
	try{
	    Thread.sleep(500);
	} catch(Exception ex) {}
	*/
    }

    public void creatFlowers() 
    {
		Texture flower = new Texture("flower", "TileSet_Main", 16*0, 16*36, 16*1, 16*37);
	
		int y_start = 26;
		int y_end = 56;
		int y = 27;
	
		for(int x = 95; x < 115; x++) 
		{
	    	while(y > y_start && y < y_end) 
	    	{
				g.setTextureGrid(flower, x, y, 0);
				y++;
	    	}
	    	y_start ++;
	    	y_end --;
	    	y = y_start+1;
		}

    }

    public void openSecretPath2() 
    {
		// change background music
		if(long3AlreadyPlayed == false) 
		{
	    	Renderer.long2.stop();
	    	Renderer.long3.play();
	    	long3AlreadyPlayed = true;
		}
	
		Texture flower = new Texture("flower", "TileSet_Main", 16*0, 16*36, 16*1, 16*37);
		for(int x = 38; x < 45; x++) 
		{
	    	Renderer.deleteTree(x,54);
	    	for(int y = 53; y < 100; y++) 
	    	{
	        	g.setTextureGrid(flower, x, y, 0);
	    	}
		}
		r.createWater(1, 10, 142, 14);
		r.createWater(151, 1, 30, 150);
    }

    public void openSecretPath3() 
    {
		// change background music
		if(long5AlreadyPlayed == false) {
	    	Renderer.long3.stop();
	    	Renderer.long5.play();
	    	long5AlreadyPlayed = true;
		}
	
		Texture flower = new Texture("flower", "TileSet_Main", 16*0, 16*36, 16*1, 16*37);
		Texture flower2 = new Texture("flower2", "TileSet_Main", 16*13, 16*39, 16*14, 16*40);
		for(int x = 25; x < 67; x++) 
		{
	    	for(int y = 10; y < 130; y++) 
	    	{
				if(g.getTextureGrid(x, y, 0).getName() != "GRASS_WILD") 
				{
		    		g.setTextureGrid(flower, x, y, 0);
				}
	    	}
		}
		r.createNiceTree(53, 27);
		r.createNiceTree(53, 29);
		r.createNiceTree(53, 31);
		r.createNiceTree(53, 33);
		r.createGod(57,29);

		for(int x = 57; x < 60; x++) 
		{
	    	g.setTextureGrid(flower2, x, 33, 0);
		}
	
		Renderer.deleteTree(64,54);
    }

    public void openSecretPath4() 
    {
		// change background music	
		if(long6AlreadyPlayed == false) {
	    	Renderer.long5.stop();
	    	Renderer.long6.play();
	    	long6AlreadyPlayed = true;
		}
		
		Texture flower2 = new Texture("flower2", "TileSet_Main", 16*13, 16*39, 16*14, 16*40);
	
	 	// delete the big pokemon there
	 	for(int x = 57; x < 60; x++) 
	 	{
	     	for(int y = 29; y < 32; y++) 
	     	{
		 		Renderer.deleteTree(x,y);
	     	}
	 	}
	 
	 	// change his position in the desert and make more flowers
	 	r.createGod(70,78);
	 	for(int x = 57; x < 60; x++) 
	 	{
	     	for(int y = 30; y < 33; y++) 
	     	{
		 		g.setTextureGrid(flower2, x, y, 0);
	     	}
	 	}

	 	ableToOpenLastPath = true;

    }

    public void openSecretPath5() {
		// change background music
		if(short3AlreadyPlayed == false) {
	    	Renderer.long6.stop();
	    	Renderer.short3.play();
	    	short3AlreadyPlayed = true;
		}
	
		Texture flower = new Texture("flower", "TileSet_Main", 16*0, 16*36, 16*1, 16*37);
		Texture flower2 = new Texture("flower2", "TileSet_Main", 16*13, 16*39, 16*14, 16*40);
		for(int x = 77; x < 84; x++) {
	    	for(int y = 37; y < 75; y += 2) 
	    	{
	        	Renderer.deleteTree(x,y);
				Renderer.deleteTree(x,y+1);
				g.setTextureGrid(flower2, x, y, 0);
				g.setTextureGrid(flower, x, y+1, 0);
	    	}
		}

		for(int x = 79; x < 82; x++) {
	    	for(int y = 75; y < 120; y+=2) {
				if(y < 90) 
				{
		    		Renderer.deleteTree(x,y);
		    		Renderer.deleteTree(x,y+1);
				}
				g.setTextureGrid(flower2, x, y, 0);
				g.setTextureGrid(flower, x, y+1, 0);
	    	}
		}
		// recreate the door 
		r.creatdoor(77,68);
    }

    public void openSecretPath6() {  // last event of the story
		// change background music
		if(long7AlreadyPlayed == false) 
		{
	    	Renderer.short3.stop();
	    	Renderer.long7.play();
	    	long7AlreadyPlayed = true;
		}
	
		Texture flower = new Texture("flower", "TileSet_Main", 16*0, 16*36, 16*1, 16*37);
		Texture flower2 = new Texture("flower2", "TileSet_Main", 16*13, 16*39, 16*14, 16*40);
		Texture grass_Wild = new Texture("GRASS_WILD", "TileSet_Main", 0, 16, 16, 32);

		// delete everything
		for(int x = 10; x < 190; x++) 
		{
	    	for(int y = 10; y < 190; y++) 
	    	{
				if(!((x>76 && x<83) && (y>31 && y<38))) 
				{
		    		Renderer.deleteTree(x,y);
		    		g.setTextureGrid(flower, x, y, 0);
				}
	    	}
		}

		// create trees as the border
		for(int x = 56; x < 104; x++) 
		{
	    	for(int y = 10; y < 59; y++) {
				if(x == 56 || x == 103 || y == 10 || y == 58) 
				{
		    		r.creatTree(x,y);
				}
	    	}
		}

		// a complex way to draw all the flowers
		int count = 0;
		for(int k=0; k<150; k++) {
	    	for(int x=1; x<199; x++) {
				for(int y=1; y<199; y++) {
		    		if(!((x>76-k && x<83+k) && (y>31-k && y<38+k))) {
						if(count % 3 == 0) {
			    			g.setTextureGrid(flower, x, y, 0);
						}
						else if(count % 3 == 1) {
			    			g.setTextureGrid(flower2, x, y, 0);
						}
						else {
			    			g.setTextureGrid(grass_Wild, x, y, 0);
						}
		    		}
				}
	    	}
	    	count++;	   	
		}
    }

    /* will have bug, Pikachu will move slower 
    public void changeSpeed() {
	player.speed = 30;
    }
    */
   
}
