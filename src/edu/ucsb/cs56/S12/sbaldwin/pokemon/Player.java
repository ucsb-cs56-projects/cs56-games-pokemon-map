package edu.ucsb.cs56.S12.sbaldwin.pokemon;

public class Player extends Character
{
	// Variables
	
	private boolean onBike;
	private boolean running;
	
	
	///// Methods
	
	// Constructor
	public Player(int x, int y, Direction rotation, String cm, String name)
	{
		super(x, y, rotation, cm, name);
		onBike = false;
		running = false;
	}
}
