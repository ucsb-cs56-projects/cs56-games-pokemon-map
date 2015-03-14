package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.event.KeyEvent;

/** The panel inside the MainWindow, it implements KeyListener to handle keyboard input
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/
class GamePanel extends JPanel implements KeyListener
{
	private int width;
	private int height;
	Renderer renderer;

        /** Two arg Constructor
	    @param width width of the panel
	    @param height height of the panel
	*/
	public GamePanel(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		renderer = GameMain.getRenderer();
		
		this.addKeyListener(this);
		this.setFocusable(true);
	}

        /** Overriding paintComponent
	    @param g
	*/
	public void paintComponent(Graphics g)
	{
	        
	    // render the texture grid
	    GameMain.gameLogic.renderNextFrame();
	    
	    // Draws the back buffer
	    g.drawImage(renderer.getFinalImage(), 0, 0, this);
		
        
	}

        /** Calls paint component on the Graphics parameter g
	    @param g
	*/
	public void update(Graphics g)
	{
		paintComponent(g);
	}

        /** Constantly repaints the panel every 10ms
	 */
	public void startLoop()
	{	
        	
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
	
        /** Notifies GameLogic that a key has been pressed
	    @param e the KeyEvent
	*/
	public void keyPressed(KeyEvent e)
	{
		GameMain.gameLogic.sendKeyPressed(e);	
	}

        /** Notifies GameLogic that a key has been released
	    @param e the KeyEvent
	*/
	public void keyReleased(KeyEvent e)
	{
		GameMain.gameLogic.sendKeyReleased(e);
	}
    	
	public void keyTyped(KeyEvent e)
	{
	
	
	}
    

}//end braces for GamePanel
