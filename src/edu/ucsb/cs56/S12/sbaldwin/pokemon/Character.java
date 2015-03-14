package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/** A class for characters that move around or can be interacted with, subclass of
    DynamicSprite
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/

public abstract class Character extends DynamicSprite {

	public static enum Direction
	{
		NORTH, SOUTH, WEST, EAST, STAGNANT
	}

	private int speed;    // Measured in pixels
	protected Direction orientation;
    protected boolean isMoving;
    private boolean moveSwitch;
	private String name;
	private String character;

	/** 5 arg constructor
	    @param x xPos of character
	    @param y yPos of character
	    @param r direction of character
	    @param name name of character
	    @param id id of sprite
	*/
	// Constructor
	public Character(int x, int y, Direction o,String name, int id)
	{
        super(x, y, 1, 2, true, id);
		this.xOffset = 0;
		this.yOffset = 0;
		this.speed =  5;      // Default speed - measured in tiles per second
		this.orientation = o;
		this.name = name;
		this.isMoving = false;
		this.moveSwitch = false;
	}

	/** Method to move the character to a new position
        Must be implemented in subclass
    */
    public abstract void move(int x, int y);

       /** Getter for character
	   @return character
       */
	public String getCharacter()
	{
		return character;
	}

        /** Getter for name
	    @return name name of character
	*/
	public String getName()
	{
		return name;
	}

        /** Getter for speed
	    @return speed, how fast the character moves
	*/
	public int getSpeed()
	{
		return this.speed;
	}

	// Setters

        /** Setter for xPos
	    @param xPos x position of character
	*/
	public void setXPos(int x)
	{
		this.xPos = x;
	}

        /** Setter for yPos
	    @param yPos y position of character
	*/
	public void setYPos(int y)
	{
		this.yPos = y;
	}

    /** Getter for orientation
        @return direction player is facing
    */
    public Direction getOrientation() {
        return orientation;
    }

    /** Setter for orientation
        @param current orientation of player
    */
    public void setOrientation(Direction o) {
        this.orientation = o;
    }

        /** Setter for name
	    @param name name of character
	*/
	public void setName(String name)
	{
		this.name = name;
	}

        /** Setter for speed
	    @param speed how fast the character moves
	*/
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

        /** Getter for isMoving
	    @return isMoving determines if the character is moving
	*/
	public boolean isMoving()
	{
		return isMoving;
	}

        /** Setter for isMoving
	    @param isMoving a boolean to indicate whether the character is moving
	*/
	public void setMoving(boolean value)
	{
		this.isMoving = value;
	}
}
