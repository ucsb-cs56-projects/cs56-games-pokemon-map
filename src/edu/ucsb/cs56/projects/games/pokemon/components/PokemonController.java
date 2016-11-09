package edu.ucsb.cs56.projects.games.pokemon.components;

import edu.ucsb.cs56.projects.games.pokemon.*;
import edu.ucsb.cs56.projects.games.pokemon.commands.MoveCommand;

import java.awt.*;

/**
 * A class to control a specific pokemon entity
 *
 * @author Steven Fields
 */
public class PokemonController extends Controller {

    Entity entity;
    InputHandler inputHandler;

    /**
     * Creates a pokemon controller
     *
     * @param entity the pokemon to control
     * @param inputHandler the input handler
     */
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