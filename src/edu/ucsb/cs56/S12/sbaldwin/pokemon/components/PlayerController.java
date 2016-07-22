package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.InputHandler;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.World;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.commands.Command;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.commands.InteractCommand;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.commands.MoveCommand;

import javax.swing.text.Position;

public class PlayerController extends Controller {

    Entity entity;
    World world;
    InputHandler inputHandler;
    PositionComponent positionComponent;

    public PlayerController(Entity entity, World world, InputHandler inputHandler) {
        this.entity = entity;
        this.world = world;
        this.inputHandler = inputHandler;
        positionComponent = new PositionComponent(0,0); // TEMP
    }

    @Override
    public void update() {
        Command moveCommand = inputHandler.moveCommand;
        inputHandler.updateMovement((MovementComponent)(entity.getComponent(MovementComponent.class)));
        Command interactCommand = inputHandler.updateInteract(positionComponent, world);
        if (moveCommand != null)
            moveCommand.execute();
        if (interactCommand != null)
            interactCommand.execute();
    }

}
