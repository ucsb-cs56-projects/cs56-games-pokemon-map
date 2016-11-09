package edu.ucsb.cs56.projects.games.pokemon.components;

import edu.ucsb.cs56.projects.games.pokemon.InputHandler;
import edu.ucsb.cs56.projects.games.pokemon.World;
import edu.ucsb.cs56.projects.games.pokemon.commands.Command;
import edu.ucsb.cs56.projects.games.pokemon.commands.InteractCommand;
import edu.ucsb.cs56.projects.games.pokemon.commands.MoveCommand;

import javax.swing.text.Position;

/**
 * A class to control a Player
 *
 * @author Steven Fields
 */
public class PlayerController extends Controller {

    Entity entity;
    World world;
    InputHandler inputHandler;
    PositionComponent positionComponent;

    /**
     * Creates a player controller
     *
     * @param entity the entity to control
     * @param world the world the entity resides in
     * @param inputHandler the input handler
     */
    public PlayerController(Entity entity, World world, InputHandler inputHandler) {
        this.entity = entity;
        this.world = world;
        this.inputHandler = inputHandler;
        positionComponent = new PositionComponent(0,0); // TEMP
    }

    @Override
    public void update() {
        /*Command moveCommand = inputHandler.moveCommand;
        inputHandler.updateMovement((MovementComponent)(entity.getComponent(MovementComponent.class)));
        Command interactCommand = inputHandler.updateInteract(positionComponent, world);
        if (moveCommand != null)
            moveCommand.execute();
        if (interactCommand != null)
            interactCommand.execute();
            */
    }

}
