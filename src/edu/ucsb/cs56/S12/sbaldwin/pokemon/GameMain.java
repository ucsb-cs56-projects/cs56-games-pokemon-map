package edu.ucsb.cs56.S12.sbaldwin.pokemon;

///// Starting point for game

/** Starting point for the game. Creates a Renderer, GameLogic, and MainWindow Object.
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/



public class GameMain
{
	public static final int SIZE = 25 * 32;

	public static Renderer renderer;
	private static MainWindow mw;
	public static GameLogic gameLogic;

        /** The starting point for the pokemon map game
	 */
	public static void main(String args[])
	{
		renderer = new Renderer(25 * 32, 25 * 32);
		gameLogic = new GameLogic();
		renderer.loadMap();
		
		mw = new MainWindow(25 * 32, 25 * 32);
	}

        /** Getter for MainWindow
	    @return mw 
	*/
	public static MainWindow getMainWindow()
	{
		return mw;
	}

        /** Getter for Renderer
	    @return renderer
	*/
	public static Renderer getRenderer()
	{
		return renderer;
	}

        /** Getter for GameLogic
	    @return gameLogic
	*/
	public static GameLogic getGameLogic()
	{
		return gameLogic;
	}
}
