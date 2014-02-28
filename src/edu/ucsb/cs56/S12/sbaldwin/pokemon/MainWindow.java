package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow
{
	JFrame frame;
	public int width;
	public int height;

	public MainWindow(int width, int height)
	{
		this.width = width;
		this.height = height;
		
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
		//<<MAKE THE WINDOW SMALLER SO IT RENDERS PROPERLY
		
		
		gp.startLoop();
	}
}
