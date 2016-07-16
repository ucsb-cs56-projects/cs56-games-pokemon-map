package edu.ucsb.cs56.S12.sbaldwin.pokemon.systems;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.Assets;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.Vector2;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.World;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.Entity;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.GraphicsComponent;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.PositionComponent;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.*;
import javafx.geometry.Pos;
import org.w3c.dom.css.Rect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * Created by William Bennett on 6/30/2016.
 */
public class RenderSystem {
    Rectangle cameraBounds;
    private static int spriteResolution = 16;
    public RenderSystem(Rectangle cameraBounds) {
        this.cameraBounds = cameraBounds;
    }

    public void draw(SpriteBatch spriteBatch, World world) {
        for (int i = 0; i < world.tiles.length; i++) {
            for (int j = 0; j < world.tiles[i].length; j++) {
                Entity e = world.tiles[i][j];
                GraphicsComponent graphicsComponent = (GraphicsComponent)e.getComponent(GraphicsComponent.class);
                if (graphicsComponent == null)
                    continue;
                PositionComponent positionComponent = (PositionComponent)e.getComponent(PositionComponent.class);
                if (positionComponent == null)
                    continue;

                spriteBatch.draw(graphicsComponent.animation.currentFrame(), scale(positionComponent.position, spriteResolution));
            }
        }
    }

    private static Rectangle scale(Rectangle rect, int amount) {
        return new Rectangle(rect.x * amount, rect.y * amount, rect.width * amount, rect.height * amount);
    }

    private static Point scale(Point point, int amount) {
        return new Point(point.x * amount, point.y * amount);
    }

    private static Vector2 scale(Vector2 vector, int amount) {
        return new Vector2(vector.x * amount, vector.y * amount);
    }
}
