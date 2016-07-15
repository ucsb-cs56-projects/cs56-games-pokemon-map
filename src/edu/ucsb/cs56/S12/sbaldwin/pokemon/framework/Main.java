package edu.ucsb.cs56.S12.sbaldwin.pokemon.framework;

///// Starting point for game

import edu.ucsb.cs56.S12.sbaldwin.pokemon.Game;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.framework.MainWindow;

/**
 * Starting point for the game. Creates a Renderer, GameLogic, and MainWindow Object.
 *
 * @author Samuel Baldwin
 * @author Marcus Liou
 * @author Alec Harrell
 */
public class Main {

    /**
     * The starting point for the pokemon map game
     */
    public static void main(String args[]) {
        MainWindow window = new Game();
        window.run();
    }
}
