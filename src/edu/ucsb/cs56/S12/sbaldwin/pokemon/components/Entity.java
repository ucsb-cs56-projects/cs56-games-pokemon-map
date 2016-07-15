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

   public Component getComponent(Class type) {
       for (Component c : components) {
           if (c.getClass().equals(type))
               return c;
       }
       return null;
   }


    // Returns itself to allow for call chaining
    public Entity addComponent(Component comp) {
        components.add(comp);
        return this;
    }
    
    
}

