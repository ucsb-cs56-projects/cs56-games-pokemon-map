package edu.ucsb.cs56.projects.games.pokemon.commands;

import edu.ucsb.cs56.projects.games.pokemon.World;
import edu.ucsb.cs56.projects.games.pokemon.components.PositionComponent;

/**
 * A command to handle interaction
 *
 * @author Steven Fields
 */
public class InteractCommand implements Command {

    public PositionComponent pc;
    public World w;

    /**
     * Constructor for an InteractCommand
     *
     * @param pc the PositionComponent
     * @param w the World
     */
    public InteractCommand(PositionComponent pc, World w) {
        this.pc = pc;
        this.w = w;
    }

    /**
     * Executes the command
     */
    public void execute() {

    }

    /**
     * Undoes the last execution
     */
    public void undo() {

    }


}
