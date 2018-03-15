package main.java.edu.ucsb.cs56.projects.games.pokemon.factories;

import main.java.edu.ucsb.cs56.projects.games.pokemon.Assets;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.CollisionComponent;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.Entity;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.GraphicsComponent;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.PositionComponent;

/**
 * Created by John Bowman on 11/8/2016.
 */
public class BuildingFactory {

    /** Creates and adds a building entity to the world, built with the specifications you give it.
     *
      * @param buildingType The type of building you wish to create
     * @param x: New building's X coordinate
     * @param y: New Building's Y coordinate
     * @return the new constructed building entity
     */
    public static Entity constructBuildingEntity(String buildingType, int x, int y) {
        Entity newBuilding = new Entity();
        newBuilding.addComponent(new PositionComponent(x, y));
        newBuilding.addComponent(new GraphicsComponent(Assets.getTexture(buildingType)));
        newBuilding.addComponent(new CollisionComponent(true, Assets.getTexture(buildingType).srcRect()));
        return newBuilding;

    }


}
