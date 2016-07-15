package edu.ucsb.cs56.S12.sbaldwin.pokemon.commands;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.PositionComponent;

import java.awt.*;

public class MoveCommand implements Command {

    
    public Point moveTo;
    public Point beforeMove;
    public PositionComponent pc;

    public MoveCommand(PositionComponent pc, Point moveTo) {
	this.pc = pc;
	this.moveTo = moveTo;
	beforeMove = new Point(0, 0);
    }
    
    public void execute() {
	beforeMove = pc.position;

	pc.position = moveTo;
    }

    public void undo() {
	pc.position = beforeMove;
    }

	
}
