package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.*;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Animation;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.AnimationFrame;

/**
 * Contains tiles and NPCs as entities
 *
 * @author Steven Fields
 */
public class World {

    public Entity[][] tiles; // Change this to tile class later when merge occurs
    private HashSet<Entity> entities;
    InputHandler inputHandler;
    Entity player;

    /**
     * Main world constructor to define tiles, entities, and the input handler
     *
     * @param tiles the tile entities
     * @param entities the entity characters
     * @param inputHandler the main input handler
     */
    public World(Entity[][] tiles, HashSet<Entity> entities, InputHandler inputHandler) {
        this.tiles = tiles;
        this.entities = entities;
        this.inputHandler = inputHandler;
        player = new Entity();
        player.addComponent(new PositionComponent(new Point(0,0)));
        player.addComponent(new GraphicsComponent(Assets.player));
        player.addComponent(new ControllableComponent(new PlayerController(player, this, inputHandler)));
        addEntity(player);
    }

    /**
     * World constructor that assumes an empty container of entity characters
     *
     * @param tiles the tile entities
     * @param inputHandler the main input handler
     */
    public World(Entity[][] tiles, InputHandler inputHandler) {
        this.tiles = tiles;
        entities = new HashSet<>();
        this.inputHandler = inputHandler;
        player = new Entity();
        player.addComponent(new PositionComponent(new Point(0,0)));
        player.addComponent(new GraphicsComponent(Assets.player));
        player.addComponent(new ControllableComponent(new PlayerController(player, this, inputHandler)));
        addEntity(player);
    }
    
    /**
     * World constructor that make empty tiles and container of entity characters
     *
     * @param inputHandler the main input handler
     */
    public World(InputHandler inputHandler) {
        entities = new HashSet<>();
        this.inputHandler = inputHandler;
        player = new Entity();
        player.addComponent(new PositionComponent(new Point(0,0)));
        player.addComponent(new GraphicsComponent(Assets.player));
        player.addComponent(new ControllableComponent(new PlayerController(player, this, inputHandler)));
        player.addComponent(new MovementComponent(Vector2.zero));
                addEntity(player);
    }
    
    /**
     * Adds entity to the hash set
     *
     * @param e the Entity
     */
    public void addEntity(Entity e) {
        entities.add(e);
    }

    /**
     * Returns an array of the entities
     *
     * @return array of entities
     */
    public Entity[] getEntities() {
        Entity[] array = new Entity[entities.size()];
        int pos = 0;
        for (Entity e : entities) {
            array[pos++] = e;
        }
        return array;
    }

    /**
     * Updates the world
     */
    public void update() {
        inputHandler.updateMovement(player);
    }
}
