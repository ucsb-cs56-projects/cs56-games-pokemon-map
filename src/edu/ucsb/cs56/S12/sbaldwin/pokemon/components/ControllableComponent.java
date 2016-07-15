package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.*;

public class ControllableComponent {

    InputHandler inputHandler;
    Entity entity;
    Controller controller;

    public ControllableComponent(InputHandler inputHandler, Entity entity, Controller controller) {
        this.inputHandler = inputHandler;
        this.entity = entity;
        this.controller = controller;
    }


}
