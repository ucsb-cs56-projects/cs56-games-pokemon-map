package edu.ucsb.cs56.S12.sbaldwin.pokemon.commands;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.PositionComponent;

import java.awt.*;

public class MoveCommand implements Command {


    public Point moveTo;
    public Point beforeMove;
    public PositionComponent positionComponent;

    public MoveCommand(PositionComponent positionComponent, Point moveTo) {
        this.positionComponent = positionComponent;
        this.moveTo = moveTo;
        beforeMove = new Point(0, 0);
    }

    public void execute() {
        beforeMove = positionComponent.position;

        positionComponent.position = moveTo;
    }

    public void undo() {
        positionComponent.position = beforeMove;
    }
}
