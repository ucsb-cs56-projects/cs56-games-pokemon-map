package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** The class for objects of type building, i.e. PokeCenters, PokeMarts, trees and houses
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
*/
class Building extends GameObject
{
	public static enum Type
	{
		POKECENTER, POKEMART
	}

        /** Three arg constructor
	    @param x xPos of building
	    @param y yPos of building
	    @param type the type of building, i.e. PokeCenter, House, tree
	*/
	public Building(int x, int y, String type)
	{
		if(type.equals("POKECENTER"))
		{
			this.createPokeCenter(x, y);
		}
		else if(type.equals("POKEMART"))
		{
			this.createPokeMart(x, y);
		}
		else if(type.equals("BASE_TREE_1"))
		{
			this.createBaseTree1(x, y);
		}
		else if(type.equals("NICE_TREE_1"))
		{
			this.createNiceTree1(x, y);
		}
		else if(type.equals("HOUSE_SMALL_1"))
		{
			this.createSmallHouse1(x, y);
		}
		else if(type.equals("HOUSE_MEDIUM_1"))
		{
			this.createMediumHouse1(x, y);
		}
		else if(type.equals("HOUSE_LARGE_1"))
		{
			this.createLargeHouse1(x, y);
		}
		else if(type.equals("BIG_FISH"))
		{
			this.createBigFish(x, y);
		}
		else if(type.equals("DOOR"))
		{
			this.createDoor(x, y);
		}
		else if(type.equals("ROCK1"))
		{
			this.createRock1(x, y);
		}
		else if(type.equals("BIGPOKEMON"))
		{
		    this.creatBigPokeMon(x, y);
		}
		else if(type.equals("BIG_BUILDING_LEFT"))
		{        
		    this.createBigBuildingLeft(x, y);
		}
		else if(type.equals("BIG_BUILDING_RIGHT"))
		{        
		    this.createBigBuildingRight(x, y);
		}
		else if(type.equals("BIG_BUILDING_2_LEFT"))
		{        
		    this.createBigBuilding2Left(x, y);
		}
		else if(type.equals("BIG_BUILDING_2_RIGHT"))
		{        
		    this.createBigBuilding2Right(x, y);
		}
		else if(type.equals("POKEBALL"))
		{        
		    this.createPokeball(x, y);
		}
		else if(type.equals("BIG_ROCK"))
		{        
		    this.createBigRock(x, y);
		}
		else if(type.equals("WATER1"))
		    {        
			this.createWater1(x, y);
		    }
		else if(type.equals("WATER2"))
		    {        
			this.createWater2(x, y);
		    }
		else if(type.equals("WATER3"))
		    {        
			this.createWater3(x, y);
		    }
		else if(type.equals("WATER4"))
		    {        
			this.createWater4(x, y);
		    }
		else if(type.equals("WATER5"))
		    {        
			this.createWater5(x, y);
		    }
		else if(type.equals("WATER6"))
		    {        
			this.createWater6(x, y);
		    }
		else if(type.equals("WATER7"))
		    {        
			this.createWater7(x, y);
		    }
		else if(type.equals("WATER8"))
		    {        
			this.createWater8(x, y);
		    }
		else if(type.equals("WATER9"))
		{        
		    this.createWater9(x, y);
		}
		
	}

        /** Creates a Pokecenter (5x5) at (x,y)
	    @param x xPos of PokeCenter
	    @param y yPos of PokeCenter
	*/
	private void createPokeCenter(int x, int y)
	{
		// Set Position and width
		this.width = 5;
		this.height = 5;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("PokeCenter", "TileSet_Main", 0, 720, 80, 800);
	}

        /** Creates a Pokemart (4x4) at (x,y)
	    @param x xPos of PokeMart
	    @param y yPos of PokeMart
	*/
	private void createPokeMart(int x, int y)
	{
		// Set Position and width
		this.width = 4;
		this.height = 4;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("PokeMart", "TileSet_Main", 0, 656, 64, 720);
	}
    
        /** Creates a base tree, 1x2, (the ones that outline the map) at (x,y)
	    @param x xPos of base tree
	    @param y yPos of base tree
	*/
	private void createBaseTree1(int x, int y)
	{
		// Set Position and width
		this.width = 1;
		this.height = 2;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("BaseTree", "TileSet_Main", 240, 3632, 256, 3664);
	}

        /** Creates a nice tree ,2x2, (the one that is surrounded by grass in this map; they are plentiful in Mossdeep city in R/S/E) at (x,y)
	    @param x xPos of nice tree
	    @param y yPos of nice tree
	*/
	private void createNiceTree1(int x, int y)
	{
		// Set Position and width
		this.width = 2;
		this.height = 2;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("NiceTree", "TileSet_Main", 192, 3696, 224, 3728);
	}

        /** Creates a small house (5x3) at (x,y)
	    @param x, xPos of small house
	    @param y, yPos of small house
	*/
        private void createSmallHouse1(int x, int y)
	{
		// Set Position and width
		this.width = 5;
		this.height = 3;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("SmallHouse", "TileSet_Main", 0, 1840, 80, 1888);
	}

        /** Creates a medium house (5x5) at (x,y)
	    @param x xPos of medium house
	    @param y yPos of meduium house
	*/	
	private void createMediumHouse1(int x, int y)
	{
		// Set Position and width
		this.width = 5;
		this.height = 5;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("MediumHouse", "TileSet_Main", 0, 1888, 80, 1968);
	}

        /** Creates a large house (7x5) at (x,y)
	    @param x xPos of large house
	    @param y yPos of large house
	*/	
	private void createLargeHouse1(int x, int y)
	{
		// Set Position and width
		this.width = 7;
		this.height = 5;
		

		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("LargeHouse", "TileSet_Main", 16, 1968, 128, 2048);
	}

    
    private void createBigFish(int x, int y){
		// Set Position and width
		this.width = 7;
		this.height = 14;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    if(!(wCounter == 3 && hCounter > 10)){
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			    }
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("BIG_FISH", "TileSet_Main", 16*8, 16*359, 16*14, 16*373);
    }

        private void createDoor(int x, int y){
		// Set Position and width
		this.width = 7;
		this.height = 7;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];

		for(int i=1; i<7; i++) {
		    collisionValue[0][i] = GameGrid.GridValue.BLOCKED;
		    collisionValue[6][i] = GameGrid.GridValue.BLOCKED;
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("DOOR", "TileSet_Main", 16*8, 16*401, 16*13, 16*406);
	}

           private void createRock1(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];

		collisionValue[0][0] = GameGrid.GridValue.BLOCKED;	        
        		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("ROCK1", "TileSet_Main", 16*3, 16*1, 16*4, 16*2);
	   }

    private void creatBigPokeMon(int x, int y){
	// Set Position and width
	this.width = 4;
	this.height = 3;
		
	this.interactable = false;
	
	// Create Collision Values and Initialize to BLOCKED
	this.collisionValue = new GameGrid.GridValue[width][height];

	for(int wCounter = 0; wCounter < this.width; wCounter ++)
	    {
		for(int hCounter = 0; hCounter < this.height; hCounter ++)
		    {
			collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
		    }
	    }
  
	this.setPos(x, y);
	
	// Set Textures, see Renderer
	this.texture = new Texture("BIGPOKEMON", "TileSet_Pkmn", 16*31, 16*17, 16*35, 16*20);
    }

    private void createBigBuildingLeft(int x, int y){
		// Set Position and width
		this.width = 8;
		this.height = 14;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;	        
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("BIG_BUILDING_LEFT", "TileSet_Main", 16*8, 16*373, 16*15, 16*387);
    }

        private void createBigBuildingRight(int x, int y){
		// Set Position and width
		this.width = 7;
		this.height = 14;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("BIG_BUILDING_RIGHT", "TileSet_Main", 16*8, 16*387, 16*14, 16*401);
    }

     private void createBigBuilding2Left(int x, int y){
		// Set Position and width
		this.width = 8;
		this.height = 13;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    if(!((wCounter<8 && wCounter > 1) && hCounter==12)) {
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			    }
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("BIG_BUILDING_2_LEFT", "TileSet_Main", 16*0, 16*469, 16*8, 16*482);
    }

         private void createBigBuilding2Right(int x, int y){
		// Set Position and width
		this.width = 7;
		this.height = 13;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("BIG_BUILDING_2_RIGHT", "TileSet_Main", 16*1, 16*482, 16*8, 16*495);
    }

            private void createPokeball(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("POKEBALL", "TileSet_Main", 16*5, 16*3, 16*6, 16*4);
    }

                private void createBigRock(int x, int y){
		// Set Position and width
		this.width = 3;
		this.height = 3;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("BIG_ROCK", "TileSet_Main", 16*10, 16*21, 16*13, 16*24);
    }

                    private void createWater1(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*5, 16*26, 16*6, 16*27);

    }

                       private void createWater2(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*6, 16*26, 16*7, 16*27);

    }

                       private void createWater3(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*7, 16*26, 16*8, 16*27);

    }

                       private void createWater4(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*5, 16*27, 16*6, 16*28);

    }

                       private void createWater5(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*6, 16*27, 16*7, 16*28);

    }

                       private void createWater6(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*7, 16*27, 16*8, 16*28);

    }

                       private void createWater7(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*5, 16*28, 16*6, 16*29);

    }

                       private void createWater8(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*6, 16*28, 16*7, 16*29);

    }

                       private void createWater9(int x, int y){
		// Set Position and width
		this.width = 1;
		this.height = 1;
		
		this.interactable = false;
		
		// Create Collision Values and Initialize to BLOCKED
		this.collisionValue = new GameGrid.GridValue[width][height];
			
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			    collisionValue[wCounter][hCounter] = GameGrid.GridValue.BLOCKED;
			}
		}
		
		this.setPos(x, y);
		
		// Set Textures, see Renderer
		this.texture = new Texture("WATER", "TileSet_Main", 16*7, 16*28, 16*8, 16*29);

    }

      
}
