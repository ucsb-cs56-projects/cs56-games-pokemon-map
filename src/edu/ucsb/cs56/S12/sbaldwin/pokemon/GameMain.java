package edu.ucsb.cs56.S12.sbaldwin.pokemon;

///// Starting point for game

import javax.swing.*;
import java.awt.*;

/** Starting point for the game. Creates a Renderer, GameLogic, and MainWindow Object.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
*/
public class GameMain
{

        /** The starting point for the pokemon map game
	 */
	public static void main(String args[])
	{
		int width = 25*32;
		int height = 25*32;

		//Create a new JFrame, with the GamePanel located in the center region
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel gp = new GamePanel(width, height);

		frame.setSize(width, height);
		frame.getContentPane().add(BorderLayout.CENTER, gp);
		frame.setLocation(50, 50);
		frame.setVisible(true);

		// Account for size of Border
		Insets insets = frame.getInsets();
		frame.setSize((width + insets.left + insets.right)+176, (height + insets.top + insets.bottom)+176);
		//window is -176 so that it renders the entire game space

		//Start the game panel
		gp.startLoop();
	}
}
