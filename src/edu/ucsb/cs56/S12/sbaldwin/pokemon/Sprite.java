package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/** The parent class for any sprite in the game.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/

public abstract class Sprite {

    protected int xPos;   // Measured in Tiles
	protected int yPos;   // Measured in Tiles
	protected int xOffset;  // Measured in pixels
	protected int yOffset;  // Measured in pixels

	protected int width;  // Measured in Tiles
	protected int height; // Measured in Tiles
	protected GameGrid.GridValue[][] collisionValue;
	protected boolean interactable;
	protected Texture texture;

    protected int id;

	private Sprite() {}

    /** 6 arg constructor
	    @param x x position of the object
	    @param y y position of the object
	    @param width width of the object
	    @param height height of the object
	    @param interactable indicate whether or not the object is interactable
	    @param id id of the sprite
	*/
	public Sprite(int x, int y, int width, int height, boolean interactable, int id)
	{
	    this.xPos = x;
	    this.yPos = y;
		this.width = width;
		this.height = height;
		this.interactable = interactable;
		this.id = id;
		this.collisionValue = new GameGrid.GridValue[width][height];
		for(int wCounter = 0; wCounter < this.width; wCounter ++) {
			for(int hCounter = 0; hCounter < this.height; hCounter++) {
				this.collisionValue[wCounter][hCounter] = GameGrid.GridValue.FREE;
			}
		}
		this.updateSpritePosition(xPos, yPos);
	}

	/** Getter for interactable
	    @return interactable whether or not the object can be interacted with
	*/
	public boolean isInteractable()
	{
		return interactable;
	}

	/** Method for interacting with sprite
        Must be implemented in subclasses
    */
	public abstract void interact();

    /** Getter for yPos
	    @return yPos vertical position of object
	*/
	public int getYPos()
	{
		return yPos;
	}

    /** Getter for xPos
	    @return xPos horizontal position of object
	*/
	public int getXPos()
	{
		return xPos;
	}

    /** Getter for width
	    @return width width of the object
	*/
	public int getWidth()
	{
		return width;
	}

    /** Getter for height
	    @return height height of object
	*/
	public int getHeight()
	{
		return height;
	}

    /** Getter for xOffset
	    @return xOffset horizontal pixel offset
	*/
	public int getXOffset()
	{
		return this.xOffset;
	}

    /** Getter for yOffset
	    @return yOffset vertical pixel offset
	*/
	public int getYOffset()
	{
		return this.yOffset;
	}

    /** Getter for texture
	    @return texture
	*/
	public Texture getTexture()
	{
		return texture;
	}

	/** Getter for id
        @return id
    */
    public int getId() {
        return id;
    }

    /** Getter for the collision value at point (x,y)
	    @param x x coordinate in question
	    @param y y coordinate in question
	    @return collisionValue[x][y] the collision value at the point
	*/
	public GameGrid.GridValue getCollisionValue(int x, int y)
	{
        return GameMain.getRenderer().getGameGrid().getCollisionGrid(x, y);
	}

	/** Check if there is a collision at x,y on game grid
        @param x x coordinate in question
        @param y y coordinate in question
        @return true if collisionValue[x][y] == BLOCKED, false otherwise
	*/
	public boolean checkCollision(int x, int y) {
	    return GameMain.getRenderer().getGameGrid().getCollisionGrid(x, y) == GameGrid.GridValue.BLOCKED;
	}

	/** Set the object at point (x,y)
	    @param x the x coordinate the object is to be set
	    @param y the y coordinate the object is to be set
	*/
	public void updateSpritePosition(int x, int y) {

		this.xPos = x;
		this.yPos = y;

		// update with new position
        GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);

        for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				GameMain.getRenderer().getGameGrid().setCollisionGrid(this.isInteractable() ? GameGrid.GridValue.BLOCKED:GameGrid.GridValue.FREE,
										  	     (xPos + wCounter), (yPos + hCounter));
			}
		}
	}

	/** Set the collision value at a certain point (x,y)
        @param value the value of the collision
        @param x the x coordinate the collision is to be set
        @param y the y coordinate the collision is to be set
    */
    public void setCollisionValue(GameGrid.GridValue value, int x, int y) {
        GameMain.getRenderer().getGameGrid().setCollisionGrid(value, x, y);
    }

    /** Setter for id
        @param id numerical id for sprite
    */
    public void setId(int id) {
        this.id = id;
    }

    /** Setter for interactable
        @param interactable whether or not the sprite has collision
    */
    public void setInteractable(boolean interactable) {
        this.interactable = interactable;
    }

    /** Method to extract the sprite from the bitmap.
        Must be implemented in subclasses.
    */
    public abstract void initializeTexture();
}


















