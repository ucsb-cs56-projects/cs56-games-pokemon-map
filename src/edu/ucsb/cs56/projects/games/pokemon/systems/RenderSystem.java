package edu.ucsb.cs56.projects.games.pokemon.systems;

import edu.ucsb.cs56.projects.games.pokemon.Assets;
import edu.ucsb.cs56.projects.games.pokemon.Vector2;
import edu.ucsb.cs56.projects.games.pokemon.World;
import edu.ucsb.cs56.projects.games.pokemon.components.Entity;
import edu.ucsb.cs56.projects.games.pokemon.components.GraphicsComponent;
import edu.ucsb.cs56.projects.games.pokemon.components.PositionComponent;
import edu.ucsb.cs56.projects.games.pokemon.graphics.*;

import java.awt.*;

import java.util.Arrays;


/**
 * Handles all rendering
 *
 * @author William Bennett
 */
public class RenderSystem extends SystemBase {
    Rectangle cameraBounds;
    private static int spriteResolution = 16;

    /**
     * Creates a render system with camera bounds
     *
     * @param cameraBounds the camera bounds
     */
    public RenderSystem(Rectangle cameraBounds) {
        this.cameraBounds = cameraBounds;
    }

    /**
     * Draws the elements to the screen with a SpriteBatch
     *
     * @param spriteBatch the SpriteBatch
     * @param world the world
     */
    public void draw(SpriteBatch spriteBatch, World world) {
        for (int i = 0; i < world.tiles.length; i++) {
            for (int j = 0; j < world.tiles[i].length; j++) {
                drawEntity(spriteBatch, world.tiles[i][j]);
            }
        }

        Entity[]  entities = world.getEntities();
        Arrays.sort(entities, (o1, o2) -> {
            PositionComponent pc1 = (PositionComponent)o1.getComponent(PositionComponent.class);
            PositionComponent pc2 = (PositionComponent)o2.getComponent(PositionComponent.class);
            if (pc1 != null && pc2 != null)
                return (pc1.position.y - pc2.position.y);
            return 0;
        });

        for (Entity e : world.getEntities()) {
            drawEntity(spriteBatch, e);
        }
    }

    /**
     * Draws an entity to the screen with a SpriteBatch
     *
     * @param spriteBatch the SpriteBatch
     * @param entity the Entity
     */
    private void drawEntity(SpriteBatch spriteBatch, Entity entity) {
        Entity e = entity;
        GraphicsComponent graphicsComponent = (GraphicsComponent)e.getComponent(GraphicsComponent.class);
        if (graphicsComponent == null)
            return;
        PositionComponent positionComponent = (PositionComponent)e.getComponent(PositionComponent.class);
        if (positionComponent == null)
            return;


        spriteBatch.draw(graphicsComponent.animation.currentFrame(), scale(positionComponent.position, spriteResolution));
    }


    /**
     * Scales a rectangle by an amount
     *
     * @param rect the rectangle
     * @param amount the scalar
     * @return the scaled rectangle
     */
    private static Rectangle scale(Rectangle rect, int amount) {
        return new Rectangle(rect.x * amount, rect.y * amount, rect.width * amount, rect.height * amount);
    }

    /**
     * Scales a point by an amount
     *
     * @param point the point
     * @param amount the scalar
     * @return the scaled point
     */
    private static Point scale(Point point, int amount) {
        return new Point(point.x * amount, point.y * amount);
    }

    /**
     * Scales a Vector2 by an amount
     *
     * @param vector the Vector2
     * @param amount the scalar
     * @return the scaled vector
     */
    private static Vector2 scale(Vector2 vector, int amount) {
        return new Vector2(vector.x * amount, vector.y * amount);
    }

    /**
     * Handles messages for the render system
     */
    @Override
    protected void handleMessages() {
        return; // STUB
    }
}
