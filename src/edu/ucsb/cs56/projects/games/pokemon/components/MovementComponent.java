package edu.ucsb.cs56.projects.games.pokemon.components;

import edu.ucsb.cs56.projects.games.pokemon.Vector2;

/**
 * A component to handle movement of the entity
 *
 * @author William Bennett
 */
public class MovementComponent extends Component {
    private static float PIOverFour = (float)Math.PI / 4f;
    public enum Direction {None, North, South, East, West}

    public Vector2 velocity;

    /**
     * Constructs a movement component from a Vector2
     *
     * @param velocity the Vector2
     */
    public MovementComponent(Vector2 velocity) {
        this.velocity = velocity;
    }

    /**
     * Returns one of four Directions that the Entity is facing
     *
     * @return the Direction the entity is facing
     */
    public Direction getDirection() {
        // Hacky solution to get the direction the component is moving
        float angle = velocity.angle();
        if (angle > PIOverFour * 7 && angle < PIOverFour)
            return Direction.East;
        else if (angle  > PIOverFour && angle < PIOverFour * 3)
            return Direction.North;
        else if (angle > PIOverFour * 3 && angle < PIOverFour * 5)
            return Direction.West;
        else if (angle > PIOverFour * 5 && angle < PIOverFour * 7)
            return Direction.South;
        return Direction.None;
    }
}
