package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.World;

public class PlayerController extends Controller {

    Entity entity;
    World world;
    
    public PlayerController(Entity entity, World world) {
	this.entity = entity;
	this.world = world;
    }

    
    
}
