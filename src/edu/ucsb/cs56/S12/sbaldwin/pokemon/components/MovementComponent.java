package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.Vector2;

/**
 * Created by William Bennett on 7/22/2016.
 */

public class MovementComponent extends Component {
    private static float PIOverFour = (float)Math.PI / 4f;
    public enum Direction {None, North, South, East, West}

    public Vector2 velocity;

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
