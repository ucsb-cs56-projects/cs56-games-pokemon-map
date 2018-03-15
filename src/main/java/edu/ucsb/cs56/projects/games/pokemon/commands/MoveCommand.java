package main.java.edu.ucsb.cs56.projects.games.pokemon.commands;

import main.java.edu.ucsb.cs56.projects.games.pokemon.components.PositionComponent;

import java.awt.*;

/**
 * A command to handle movement
 *
 * @author Steven Fields
 */
public class MoveCommand implements Command {


    public Point moveTo;
    public Point beforeMove;
    public PositionComponent positionComponent;

    /**
     * Creates a move command with a position and a point to move it to
     *
     * @param positionComponent the position component
     * @param moveTo the point to move to
     */
    public MoveCommand(PositionComponent positionComponent, Point moveTo) {
        this.positionComponent = positionComponent;
        this.moveTo = moveTo;
        beforeMove = new Point(0, 0);
    }

    /**
     * Executes the move
     */
    public void execute() {
        beforeMove = positionComponent.position;

        positionComponent.position = moveTo;
    }

    /**
     * Undoes the last move
     */
    public void undo() {
        positionComponent.position = beforeMove;
    }
}
