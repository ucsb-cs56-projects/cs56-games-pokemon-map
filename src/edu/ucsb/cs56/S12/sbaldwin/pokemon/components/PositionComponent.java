package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import com.sun.javafx.geom.Vec2f;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.Vector2;

import java.awt.geom.Point2D;

/**
 * Created by William Bennett on 6/29/2016.
 */

// Component for the position of the owner entity
public class PositionComponent extends Component {
    public Vector2 position;

    public PositionComponent(Vector2 position) {
        this.position = position;
    }
}
