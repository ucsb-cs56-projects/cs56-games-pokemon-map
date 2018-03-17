package edu.ucsb.cs56.projects.games.pokemon;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

import edu.ucsb.cs56.projects.games.pokemon.components.*;
import edu.ucsb.cs56.projects.games.pokemon.graphics.Animation;
import edu.ucsb.cs56.projects.games.pokemon.graphics.AnimationFrame;
import edu.ucsb.cs56.projects.games.pokemon.factories.*;

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
    Entity player1;

    //also seems to useless

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
        player.addComponent(new PositionComponent(new Point(20,20)));
        player.addComponent(new GraphicsComponent(new Animation(Assets.playerAnimation)));
        player.addComponent(new ControllableComponent(new PlayerController(player, this, inputHandler)));
    	player.addComponent(new MovementComponent(Vector2.zero));
        player.addComponent(new CollisionComponent(false, 1, 2));
        addEntity(player);

    }

    // //not useful in our case, we always set container


    
    // /**
    //  * World constructor that assumes an empty container of entity characters
    //  *
    //  * @param tiles the tile entities
    //  * @param inputHandler the main input handler
    //  */

    //This is the constructor that we actually use
    public World(Entity[][] tiles, InputHandler inputHandler) {
        this.tiles = tiles;
        entities = new HashSet<>();
	for (int i = 0; i < tiles.length; i++ ) {
	    for ( int j = 0; j < tiles[0].length; j++) {
		CollisionComponent CC = (CollisionComponent)tiles[i][j].getComponent(CollisionComponent.class);
		if (CC.hasCollision) {
		    addEntity(tiles[i][j]);
		}
	    }
	}
        this.inputHandler = inputHandler;
        player = new Entity();
        player.addComponent(new PositionComponent(new Point(20,20)));
        player.addComponent(new GraphicsComponent(new Animation(Assets.playerAnimation)));
        player.addComponent(new ControllableComponent(new PlayerController(player, this, inputHandler)));
    	player.addComponent(new MovementComponent(Vector2.zero));
        player.addComponent(new CollisionComponent(false, 1, 2));
        addEntity(player);

       	player1 = new Entity();
        player1.addComponent(new PositionComponent(new Point(19,20)));
        player1.addComponent(new GraphicsComponent(new Animation(Assets.pikachuAnimation)));
        player1.addComponent(new ControllableComponent(new PlayerController(player1, this, inputHandler)));
        player1.addComponent(new MovementComponent(Vector2.zero));
        player1.addComponent(new CollisionComponent(false, 1, 2));
        addEntity(player1);
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
        player.addComponent(new PositionComponent(new Point(20,20)));
	//determine the initial phase(which side should player face) when init
        player.addComponent(new GraphicsComponent(new Animation(Assets.playerAnimation)));
        player.addComponent(new ControllableComponent(new PlayerController(player, this, inputHandler)));
        player.addComponent(new MovementComponent(Vector2.zero));
        player.addComponent(new CollisionComponent(false, 1, 2));
        addEntity(player);


	player1 = new Entity();
        player1.addComponent(new PositionComponent(new Point(19,20)));
        player1.addComponent(new GraphicsComponent(new Animation(Assets.pikachuAnimation)));
        player1.addComponent(new ControllableComponent(new PokemonController(player1,this, inputHandler)));
        player1.addComponent(new MovementComponent(Vector2.zero));
        player1.addComponent(new CollisionComponent(false, 1, 2));
        addEntity(player1);
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
       ((GraphicsComponent)player.getComponent(GraphicsComponent.class)).animation.advance(.99f,
               (MovementComponent)player.getComponent(MovementComponent.class));

         

    
    }
}
