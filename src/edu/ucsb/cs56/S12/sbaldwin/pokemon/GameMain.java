package edu.ucsb.cs56.S12.sbaldwin.pokemon;

///// Starting point for game

public class GameMain
{
	public static Renderer renderer;
	private static MainWindow mw;
	public static GameLogic gameLogic;

	public static void main(String args[])
	{
		renderer = new Renderer(25 * 32, 25 * 32);
		gameLogic = new GameLogic();
		renderer.loadMap();
		
		mw = new MainWindow(25 * 32, 25 * 32);
	}
	
	public static MainWindow getMainWindow()
	{
		return mw;
	}
	
	public static Renderer getRenderer()
	{
		return renderer;
	}
	
	public static GameLogic getGameLogic()
	{
		return gameLogic;
	}
}
