package main.java.edu.ucsb.cs56.projects.games.pokemon.factories;

import main.java.edu.ucsb.cs56.projects.games.pokemon.Assets;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.CollisionComponent;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.Entity;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.GraphicsComponent;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.PositionComponent;

/**
 * Created by John Bowman on 11/16/2016.
 */
public class ObstacleFactory {
    /** Creates and adds an obstacle entity to the world, built with the specifications you give it.
     *
     * This has been made separate from the BuildingFactory to account for the possibility of a future
     * Group that might want to create the ability to enter buildings and load a new map.
     *
     * @param obstacleType The type of building you wish to create
     * @param x: New building's X coordinate
     * @param y: New Building's Y coordinate
     * @return the new constructed obstacle entity
     */
    public static Entity constructObstacleEntity(String obstacleType, int x, int y) {
        Entity newObstacle = new Entity();
        newObstacle.addComponent(new PositionComponent(x, y));
        newObstacle.addComponent(new GraphicsComponent(Assets.getTexture(obstacleType)));
        newObstacle.addComponent(new CollisionComponent(true, Assets.getTexture(obstacleType).srcRect()));
        return newObstacle;

    }
}
