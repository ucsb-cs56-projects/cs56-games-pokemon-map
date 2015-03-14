package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** The window frame for the Pokemon map game
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/
public class MainWindow
{
	JFrame frame;
	public int width;
	public int height;

        /** Two arg constructor
	    @param width width of the window
	    @param height height of the window
	*/
	public MainWindow(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		//Create a new JFrame, with the GamePanel located in the center region
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel gp = new GamePanel(width, height);

		frame.setSize(width, height);		
		frame.getContentPane().add(BorderLayout.CENTER, gp);		
		frame.setLocation(50, 50);
		frame.setVisible(true);
		
		// Account for size of Border
		Insets insets = frame.getInsets();
		frame.setSize((width + insets.left + insets.right)-176, (height + insets.top + insets.bottom)-176);
		//window is -176 so that it renders the entire game space
		
		//Start the game panel
		gp.startLoop();
	}
}
