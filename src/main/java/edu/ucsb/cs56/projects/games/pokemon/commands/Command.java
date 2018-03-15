package main.java.edu.ucsb.cs56.projects.games.pokemon.commands;

/**
 * An interface for commands
 *
 * @author Steven Fields
 */
public interface Command {

    public void execute();

    public void undo();

}
