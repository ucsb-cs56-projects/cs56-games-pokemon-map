package edu.ucsb.cs56.projects.games.pokemon.factories;

import edu.ucsb.cs56.projects.games.pokemon.Assets;
import edu.ucsb.cs56.projects.games.pokemon.World;
import edu.ucsb.cs56.projects.games.pokemon.components.Entity;
import edu.ucsb.cs56.projects.games.pokemon.components.GraphicsComponent;
import edu.ucsb.cs56.projects.games.pokemon.components.PositionComponent;
import edu.ucsb.cs56.projects.games.pokemon.components.TileComponent;
import edu.ucsb.cs56.projects.games.pokemon.TileData;
import edu.ucsb.cs56.projects.games.pokemon.graphics.Texture;


/**
 * Created by John Bowman on 11/8/2016.
 */
public class BuildingFactory {

    /** Creates and adds a building entity to the world, built with the specifications you give it.
     *
      * @param buildingType The type of building you wish to create
     * @param x: New building's X coordinate
     * @param y: New Building's Y coordinate
     */
    public static Entity constructBuildingEntity(String buildingType, int x, int y) {
        Entity newBuilding = new Entity();
        newBuilding.addComponent(new PositionComponent(x, y));
        newBuilding.addComponent(new GraphicsComponent(Assets.getTexture(buildingType)));
        return newBuilding;

    }


}
