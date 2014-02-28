package edu.ucsb.cs56.S12.sbaldwin.pokemon;


class Building extends GameObject
{
	public static enum Type
	{
		POKECENTER, POKEMART
	}

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
	}
	
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
		
		// Set Textures
		this.texture = new Texture("PokeCenter", "TileSet_Main", 0, 720, 80, 800);
	}
	
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
		
		// Set Textures
		this.texture = new Texture("PokeMart", "TileSet_Main", 0, 656, 64, 720);
	}
	
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
		
		// Set Textures
		this.texture = new Texture("BaseTree", "TileSet_Main", 240, 3632, 256, 3664);
	}
	
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
		
		// Set Textures
		this.texture = new Texture("NiceTree", "TileSet_Main", 192, 3696, 224, 3728);
	}
	
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
		
		// Set Textures
		this.texture = new Texture("SmallHouse", "TileSet_Main", 0, 1840, 80, 1888);
	}
	
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
		
		// Set Textures
		this.texture = new Texture("MediumHouse", "TileSet_Main", 0, 1888, 80, 1968);
	}
	
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
		
		// Set Textures
		this.texture = new Texture("LargeHouse", "TileSet_Main", 16, 1968, 128, 2048);
	}

}
