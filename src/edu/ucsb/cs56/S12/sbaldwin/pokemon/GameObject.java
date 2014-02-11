package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


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
	
	protected boolean interactable;
	
	
	public GameObject()
	{
		/*
		this.xPos = 0;
		this.yPos = 0;
		
		this.width = 1;
		this.height = 1;
		
		collisionValue = new GameGrid.GridValue[width][height];
		collisionValue[0][0] = GameGrid.GridValue.FREE;
		
		interactable = false;
		
		texture = GameMain.getRenderer().getTile(0, 0, 16, 16);
		*/
	}
	
	public GameObject(int x, int y, int width, int height, boolean interactable)
	{
		this.width = width;
		this.height = height;
		
		this.interactable = interactable;
		
		// Create Collision Values and Initialize to FREE
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
	
	public boolean isInteractable()
	{
		return interactable;
	}
	
	public void interact()
	{
		return;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getXOffset()
	{
		return this.xOffset;
	}
	
	public int getYOffset()
	{
		return this.yOffset;
	}
	
	public Texture getTexture()
	{
		return texture;
	}
	
	public GameGrid.GridValue getCollisionValue(int x, int y)
	{
		return collisionValue[x][y];
	}
	
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
	
	public void updatePos()
	{
		GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
	}
	
	public void setCollisionValue(GameGrid.GridValue cv, int x, int y)
	{
		this.collisionValue[x][y] = cv;
		
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
