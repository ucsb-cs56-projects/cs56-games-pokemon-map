package main.java.edu.ucsb.cs56.projects.games.pokemon.components;

import java.util.ArrayList;

/**
 * A class to hold components that make up an entity
 *
 * @author Steven Fields
 * @author William Bennett
 */
public class Entity {

    private ArrayList<Component> components;

    /**
     * Creates an entity with no components
     */
    public Entity() {
        components = new ArrayList<Component>();
    }

    /**
     * Creates an entity with components
     *
     * @param components the ArrayList of components
     */
    public Entity(ArrayList<Component> components) {
        this.components = components;
    }

    /**
     * Returns the ArrayList of components
     *
     * @return the ArrayList of components
     */
    public ArrayList<Component> getComponents() {
        return components;
    }

    /**
     * Returns a specific component in the entity
     *
     * @param type the Class of the component
     * @return the Component
     */
   public Component getComponent(Class type) {
       for (Component c : components) {
           if (c.getClass().equals(type))
               return c;
       }
       return null;
   }


    // Returns itself to allow for call chaining
    /**
     * Adds a component, can be chained
     * 
     * @param comp the Component
     * @return this Entity
     */
    public Entity addComponent(Component comp) {
        components.add(comp);
        return this;
    }
    
    
}

