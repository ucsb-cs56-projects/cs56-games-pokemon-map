package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.Vector2;

import java.awt.*;


/**
 * Created by William Bennett on 6/29/2016.
 */

// Component for the position of the owner entity
public class PositionComponent extends Component {

    public Point position;
    public Vector2 offset;

    /**
     * Creates a postition component from an x and y value and a offset
     *
     * @param x the x value
     * @param y the y value
     * @param offset the Vector2 for offset
     */
    public PositionComponent(int x, int y, Vector2 offset) {
        position = new Point(x, y);
        this.offset = offset;
    }

    /**
     * Creates a position component from a point and a offset
     *
     * @param position the Point
     * @param offset the Vector2 for offset
     */
    public PositionComponent(Point position, Vector2 offset) {
        this.position = position;
        this.offset = offset;
    }

    /**
     * Creates a position component from a x and y value with a offset of 0, 0
     *
     * @param x the x value
     * @param y the y value
     */
    public PositionComponent(int x, int y) {
        this(x, y, new Vector2(0, 0));

    }

    /**
     * Creates a position component from a Point with a offset of 0, 0
     *
     * @param position the Point
     */
    public PositionComponent(Point position) {
        this(position, new Vector2(0, 0));
    }


}
