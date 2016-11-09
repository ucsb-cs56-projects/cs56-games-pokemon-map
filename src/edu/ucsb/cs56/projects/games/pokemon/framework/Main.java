package edu.ucsb.cs56.projects.games.pokemon.framework;

///// Starting point for game

import edu.ucsb.cs56.projects.games.pokemon.Game;
import edu.ucsb.cs56.projects.games.pokemon.framework.MainWindow;

/**
 * Starting point for the game. Creates a MainWindow
 *
 * @author Samuel Baldwin
 * @author Marcus Liou
 * @author Alec Harrell
 */
public class Main {

    /**
     * The starting point for the pokemon map game
     *
     * @param args array of arguments, no use
     */
    public static void main(String args[]) {
        MainWindow window = new Game();
        window.run();

    }
}
