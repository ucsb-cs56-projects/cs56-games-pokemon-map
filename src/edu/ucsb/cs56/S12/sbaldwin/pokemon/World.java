package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.util.ArrayList;
import java.util.HashSet;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.Entity;

/**
 * Created by steven on 6/30/16.
 */
public class World {

    public Entity[][] tiles; // Change this to tile class later when merge occurs
    private HashSet<Entity> entities;

    // Basic skeleton for world class
    public World(Entity[][] tiles, HashSet<Entity> entities) {
        this.tiles = tiles;
        this.entities = entities;
    }

    public World(Entity[][] tiles) {
        this.tiles = tiles;
        entities = new HashSet<Entity>();
    }

    public World() {
        entities = new HashSet<>();
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public Entity[] getEntities() {
        Entity[] array = new Entity[entities.size()];
        int pos = 0;
        for (Entity e : entities) {
            array[pos++] = e;
        }
        return array;
    }
}
