package main.java.edu.ucsb.cs56.projects.games.pokemon.components;

import main.java.edu.ucsb.cs56.projects.games.pokemon.*;

/**
 * A component to control a entity
 *
 * @author Steven Fields
 */
public class ControllableComponent extends Component{

    public Controller controller;

    /**
     * Construcst a controllable component from a controller
     *
     * @param controller the Controller
     */
    public ControllableComponent(Controller controller) {
        this.controller = controller;
    }



}
