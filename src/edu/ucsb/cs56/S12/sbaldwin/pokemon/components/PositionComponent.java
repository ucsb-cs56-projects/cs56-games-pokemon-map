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

    public PositionComponent(int x, int y, Vector2 offset) {
        position = new Point(x, y);
        this.offset = offset;
    }

    public PositionComponent(Point position, Vector2 offset) {
        this.position = position;
        this.offset = offset;
    }

    public PositionComponent(int x, int y) {
        this(x, y, new Vector2(0, 0));

    }

    public PositionComponent(Point position) {
        this(position, new Vector2(0, 0));
    }


}
