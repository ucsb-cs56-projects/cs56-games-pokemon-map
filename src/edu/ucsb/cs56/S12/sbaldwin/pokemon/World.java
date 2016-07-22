package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.*;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Animation;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.AnimationFrame;

/**
 * Created by steven on 6/30/16.
 */
public class World {

    public Entity[][] tiles; // Change this to tile class later when merge occurs
    private HashSet<Entity> entities;
    InputHandler inputHandler;
    Entity player;

    // Basic skeleton for world class
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

    public void update() {
        inputHandler.updateMovement(player);
    }
}
