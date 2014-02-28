package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** The class for the Object of type Player. This is the actual character you control, and is a subclass of Character.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
*/
public class Player extends Character
{
	// Variables
	
	private boolean onBike;
	private boolean running;
	
	
	///// Methods

        /** Five arg constructor
	    @param x initial xPos
	    @param y initial yPos
	    @param rotation initial direction to be facing, i.e. NORTH, SOUTH, EAST, WEST
	    @param cm the character model
	    @param name the name of the character
	*/
	// Constructor
	public Player(int x, int y, Direction rotation, String cm, String name)
	{
		super(x, y, rotation, cm, name);
		onBike = false;
		running = false;
	}
}
