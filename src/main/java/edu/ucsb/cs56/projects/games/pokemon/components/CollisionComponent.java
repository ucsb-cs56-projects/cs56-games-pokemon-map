package edu.ucsb.cs56.projects.games.pokemon.components;

import java.awt.*;

/**
 * A component for handling collision of entities
 * @author John Bowman
 *
 * created 11/17/2016
 */
public class CollisionComponent extends Component {
    public boolean hasCollision;
    public int width;
    public int height;

    /**
     * Creates a CollisionComponent from a boolean value, width, and height
     * The entity's hitbox is constructed elsewhere using the width and height values
     *
     * @param objectHasCollision true if the entity is collideable, false if not
     * @param objectWidth width of the entity
     * @param objectHeight height of the entity
     */
    public CollisionComponent(boolean objectHasCollision, int objectWidth, int objectHeight){
        hasCollision = objectHasCollision;
        width = objectWidth / 16;
        height = objectHeight / 16;
    }

    /**
     * Creates a CollisionComponent from a boolean value and the width/height values
     * of a Rectangle
     *
     * @param objectHasCollision true if the entity is collideable, false if not
     * @param bounds The bounds of the entity's rectangular hitbox
     */
    public CollisionComponent(boolean objectHasCollision, Rectangle bounds) {
        hasCollision = objectHasCollision;
        width = bounds.width / 16 - 1;
        height = (bounds.height / 16) - 1;
    }

    public CollisionComponent() {
        hasCollision = false;
        width = 0;
        height = 0;
    }

}
