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

}
