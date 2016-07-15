package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import com.sun.javafx.geom.Vec2f;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.Vector2;

import java.awt.geom.Point2D;

/**
 * Created by William Bennett on 6/29/2016.
 */

// Component for the position of the owner entity
public class PositionComponent extends Component {
    public Point2D position;

    public PositionComponent(float x, float y) {
	position = new Point2D.Float(x, y);
    }

    public PositionComponent(Point2D position) {
	this.position = position;
    }

}
