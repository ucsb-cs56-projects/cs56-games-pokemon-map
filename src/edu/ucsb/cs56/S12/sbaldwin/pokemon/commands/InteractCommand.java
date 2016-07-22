package edu.ucsb.cs56.S12.sbaldwin.pokemon.commands;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.World;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.PositionComponent;

public class InteractCommand implements Command {

    public PositionComponent pc;
    public World w;

    public InteractCommand(PositionComponent pc, World w) {
        this.pc = pc;
        this.w = w;
    }

    public void execute() {

    }

    public void undo() {

    }


}
