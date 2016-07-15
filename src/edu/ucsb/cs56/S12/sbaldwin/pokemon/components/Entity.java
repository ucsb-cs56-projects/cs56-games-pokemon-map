package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import java.util.ArrayList;

public class Entity {

    private ArrayList<Component> components;

    public Entity() {
	components = new ArrayList<Component>();
    }

    public Entity(ArrayList<Component> components) {
	this.components = components;
    }

    public ArrayList<Component> getComponents() {
	return components;
    }

    
    
}

