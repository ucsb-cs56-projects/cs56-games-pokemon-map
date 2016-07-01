package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.awt.event.KeyEvent;

/** GameLogic tells the program when to do what when a key is pressed.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
*/
public class GameLogic
{
    World w;
	InputHandler ip;
    /** No arg constructor
     */

	public GameLogic() {
		ip = new InputHandler();
	}

	public GameLogic(World w, Renderer r) {
		this();

	} // Not sure what we need for constructor yet

	public void updateInput() {
		ip.update();
	}

	public void updatePhysics() {
		// Check for collision with physics component
	}

   
}
