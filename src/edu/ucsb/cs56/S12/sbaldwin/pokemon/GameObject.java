package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/** The parent class for any object in the game.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
*/
public class GameObject
{
	protected int xPos;   // Measured in Tiles
	protected int yPos;   // Measured in Tiles
	protected int xOffset;  // Measured in pixels
	protected int yOffset;  // Measured in pixels

	protected int width;  // Measured in Tiles
	protected int height; // Measured in Tiles
	
	protected GameGrid.GridValue[][] collisionValue;
	
	protected Texture texture;
	
	protected boolean pkmn;
	protected boolean interactable;
	
        /** No arg constructor
	 */
        public GameObject()
        {
        }

        /** Five arg constructor
	    @param x x position of the object
	    @param y y position of the object
	    @param width width of the object
	    @param height height of the object
	    @param interactable indicate whether or not the object is interactable
	*/
	public GameObject(int x, int y, int width, int height, boolean interactable)
	{
		this.width = width;
		this.height = height;
		this.pkmn = pkmn;
		this.interactable = interactable;

            collisionValue = new GameGrid.GridValue[width][height];
		
            for(int wCounter = 0; wCounter < this.width; wCounter ++)
            {
                for(int hCounter = 0; hCounter < this.height; hCounter ++)
                {
				collisionValue[wCounter][hCounter] = GameGrid.GridValue.FREE;
                }
            }
		// Set the position (Has to be after the Initialization of collisionValues
		this.setPos(x, y);

		
	}

        /** Getter for interactable
	    @return interactable whether or not the object can be interacted with
	*/
	public boolean isInteractable()
	{
		return interactable;
	}

        /** Performs an action when interacted with
	 */
    //is not currently used in the program	
	public void interact()
	{
		return;
	}

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

        /** Getter for the collision value at point (x,y)
	    @param x x coordinate in question
	    @param y y coordinate in question
	    @return collisionValue[x][y] the collision value at the point
	*/
	public GameGrid.GridValue getCollisionValue(int x, int y)
	{
       
            return collisionValue[x][y];
        
        
	}

        /** Set the object at point (x,y)
	    @param x the x coordinate the object is to be set
	    @param y the y coordinate the object is to be set
	*/
	public void setPos(int x, int y)
	{
		this.xPos = x;
		this.yPos = y;
		
        
            // Update the Object Grid
            GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
      
            // Update the Collision Grid
            for(int wCounter = 0; wCounter < this.width; wCounter ++)
            {
                for(int hCounter = 0; hCounter < this.height; hCounter ++)
                {
                    if(collisionValue[wCounter][hCounter] != GameGrid.GridValue.FREE)
                    {
                        GameMain.getRenderer().getGameGrid().setCollisionGrid(collisionValue[wCounter][hCounter],
										  	     (xPos + wCounter), (yPos + hCounter));
                    }
										     
                }
            }
        
	}

        /** Sets the object grid using the current values of xPos and yPos
	 */    
	public void updatePos()
	{
            GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
	}

        /** Sets the collision value at point (x,y) to cv
	    @param cv the collision value
	    @param x the x position
	    @param y the y position
	*/
	public void setCollisionValue(GameGrid.GridValue cv, int x, int y)
	{

            this.collisionValue[x][y] = cv;
	    //Very gimmicky way to make sure Pikachu gets initialized without a collision value. Pikachu is initialized at x=44				       
	    if(x!=44)
		{	
		    // Update the Grid
		    for(int wCounter = 0; wCounter < this.width; wCounter ++)
			{
			    for(int hCounter = 0; hCounter < this.height; hCounter ++)
				{
				    if(collisionValue[wCounter][hCounter] != GameGrid.GridValue.FREE)
					{
					    GameMain.getRenderer().getGameGrid().setCollisionGrid(collisionValue[wCounter][hCounter],
										  	     (xPos + wCounter), (yPos + hCounter));
					}
				}
			}
		}
        
    
	}
}//end bracket for GameObject
