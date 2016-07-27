package edu.ucsb.cs56.S12.sbaldwin.pokemon.commands;

/**
 * An interface for commands
 *
 * @author Steven Fields
 */
public interface Command {

    public void execute();

    public void undo();

}
