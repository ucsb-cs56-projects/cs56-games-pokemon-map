package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.*;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.commands.MoveCommand;

import java.awt.*;

public class PokemonController extends Controller {

    Entity entity;
    InputHandler inputHandler;

    public PokemonController(Entity entity, InputHandler inputHandler) {
        this.entity = entity;
        this.inputHandler = inputHandler;
    }

    @Override
    public void update() {
        MoveCommand moveCommand = inputHandler.moveCommand;
        Point moveTo = moveCommand.beforeMove; // Set Pokemon's Position to this point, a bit more hacky than the player controller
    }

}