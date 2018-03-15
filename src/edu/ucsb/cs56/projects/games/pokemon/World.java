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
    // public World(Entity[][] tiles, HashSet<Entity> entities, InputHandler inputHandler) {
    //     this.tiles = tiles; 
    //     this.entities = entities;
    //     this.inputHandler = inputHandler;
    //     player = new Entity();
    //     player.addComponent(new PositionComponent(new Point(20,20)));
    //     player.addComponent(new GraphicsComponent(new Animation(Assets.playerAnimation)));
    //     player.addComponent(new ControllableComponent(new PlayerController(player, this, inputHandler)));
    // 	player.addComponent(new MovementComponent(Vector2.zero));
    //     player.addComponent(new CollisionComponent(false, 1, 2));
    //     addEntity(player);

    // 	// //try to add another player player1
    // 	// player1 = new Entity();
    //     // player1.addComponent(new PositionComponent(new Point(30,30)));
    //     // player1.addComponent(new GraphicsComponent(Assets.player1));
    //     // player1.addComponent(new ControllableComponent(new PlayerController(player1, this, inputHandler)));
    //     // addEntity(player1);



    //     addEntity(BuildingFactory.constructBuildingEntity("pokecenter",0,0));

    // }

    // //not useful in our case, we always set container

    // /**
    //  * World constructor that assumes an empty container of entity characters
    //  *
    //  * @param tiles the tile entities
    //  * @param inputHandler the main input handler
    //  */
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




	//truly add a static player1 that is idential image as old player
	player1 = new Entity();
        player1.addComponent(new PositionComponent(new Point(19,20)));
        player1.addComponent(new GraphicsComponent(new Animation(Assets.pikachuAnimation)));
        player1.addComponent(new ControllableComponent(new PlayerController(player1, this, inputHandler)));
        player1.addComponent(new MovementComponent(Vector2.zero));
        player1.addComponent(new CollisionComponent(false, 1, 2));
        addEntity(player1);





	

        // addEntity(BuildingFactory.constructBuildingEntity("pokecenter",30,10));
        // addEntity(BuildingFactory.constructBuildingEntity("pokemart",10,30));
        // addEntity(BuildingFactory.constructBuildingEntity("smallHouse", 20, 5));
        // addEntity(BuildingFactory.constructBuildingEntity("largeHouse", 12, 5));
        // addEntity(BuildingFactory.constructBuildingEntity("mediumHouse", 15, 10));
    	
        
        //left border of trees
        //addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 2));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 4));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 6));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 8));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 10));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 12));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 14));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 16));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 18));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 20));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 22));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 24));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 26));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 28));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 30));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 32));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 34));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 36));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 0, 38));
    	
    	// //top border
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 2, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 4, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 6, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 8, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 10, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 12, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 14, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 16, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 18, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 20, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 22, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 24, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 26, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 28, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 30, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 32, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 34, 0));
    	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree2", 36, 0));
    	
    	// //right border
    	// // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 0));
    	// // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 2));
    	// // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 4));
    	// // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 6));
    	// // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 8));
    	// // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 10));
    	// // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 12));
	// // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 14));
	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 16));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 18));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 20));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 22));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 24));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 26));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 28));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 30));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 32));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 34));
       	// addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 36));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree", 38, 38));
		
	// 	//bottom border
	// 	addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 2, 38));
        // // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 4, 38));
        // // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 6, 38));
        // // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 8, 38));
        // // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 10, 38));
        // // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 12, 38));
        // // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 14, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 16, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 18, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 20, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 22, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 24, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 26, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 28, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 30, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 32, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 34, 38));
        // addEntity(ObstacleFactory.constructObstacleEntity("workingTree3", 36, 38));
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

       //can not just copy, o.w. two players can not move
       //need to figure out how pair.java works
       
       // inputHandler.updateMovement(player1);
       // ((GraphicsComponent)player1.getComponent(GraphicsComponent.class)).animation.advance(.99f,
       //         (MovementComponent)player1.getComponent(MovementComponent.class));


       
    
    }
}
