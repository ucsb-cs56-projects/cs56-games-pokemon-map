package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.KeyEvent;

class GamePanel extends JPanel implements KeyListener
{
	private int width;
	private int height;
	Renderer renderer;

	public GamePanel(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		renderer = GameMain.getRenderer();
		
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void paintComponent(Graphics g)
	{
		//System.out.print("Rendering new frame...");
		// render the texture grid
		GameMain.gameLogic.renderNextFrame();
		
		// Draws the back buffer
		g.drawImage(renderer.getFinalImage(), 0, 0, this);
		
		//System.out.println("Finished");
	}

	public void update(Graphics g)
	{
		paintComponent(g);
	}
	
	public void startLoop()
	{	
		//renderer.renderTextureGrid();
		//this.repaint();	
		while(true)
		{
			this.repaint();
	
			try
			{
				Thread.sleep(10);
			}
			catch(Exception ex){}
		}
	}
	
	
	////////////////////////////INPUT///////////////////////////////		

	public void keyPressed(KeyEvent e)
	{
		GameMain.gameLogic.sendKeyPressed(e);	
	}
	
	public void keyReleased(KeyEvent e)
	{
		GameMain.gameLogic.sendKeyReleased(e);
	}
	
	public void keyTyped(KeyEvent e)
	{
	
	
	}


}
