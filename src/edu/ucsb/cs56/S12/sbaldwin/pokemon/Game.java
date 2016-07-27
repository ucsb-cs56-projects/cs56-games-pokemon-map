package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.IO.MapLoader;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.framework.MainWindow;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.SpriteBatch;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.systems.MovementSystem;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.systems.RenderSystem;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.systems.SystemMessenger;

import java.awt.*;

/**
 * Put ALL game logic in this class, or in objects rooted in this class
 *
 * @author William Bennett
 */
public class Game extends MainWindow {
    private static String testMap = "map_name {" +
            "width:4        height:4" +
            "[0, 0, 0], [0, 1, 0], [0, 2, 0], [0, 3, 0], [0, 0, 1], [0, 1, 1],[0, 2, 1], [0, 3, 1]," +
            "[0, 0, 2], [0, 1, 2], [0, 2, 2], [0, 3, 2], [0, 0, 3], [0, 1, 3],[0, 2, 3], [0, 3, 3]," +
            "}";

    World world;
    RenderSystem renderSystem;
    SystemMessenger systemMessenger;
    MovementSystem movementSystem;

    /**
     * Game constructor that simply calls the constructor of its super class, MainWindow
     */
    public Game() {
        super();
    }

    
    /**
     * Initialize all non-asset resources such as the world, the system manager, the maploader, etc.
     */
    public void init() {
	// create world
	//
        super.init();
        InputHandler inputHandler = new InputHandler();
        this.addKeyListener(inputHandler);
	    systemMessenger = new SystemMessenger();
	    inputHandler.registerMessenger(systemMessenger);
        movementSystem = new MovementSystem();
        movementSystem.registerMessenger(systemMessenger);
        world = new World(inputHandler);
        renderSystem = new RenderSystem(this.getBounds());
        MapLoader ml = new MapLoader();
        ml.loadMap(testMap, world);
    }

    /**
     * Load all asset resources such as textures and sound
     */
    public void load() {
	// load assets
        super.load();
        Assets.initAssets();
    }

    /**
     * Update the game and move it forward by a delta time
     * @param gameTime is the delta time to move the game forward
     */
    public void update(float gameTime) {
        super.update(gameTime);
        world.update();
        movementSystem.applyMovement(gameTime, world);
    }

    /**
     * Draw to the screen using a sprite batch and a delta time
     * @param spriteBatch is the sprite batch that draws to the screen
     * @param gameTime is the delta time to move the drawing forward
     */
    public void draw(SpriteBatch spriteBatch, float gameTime) {
        super.draw(spriteBatch, gameTime);
	    renderSystem.draw(spriteBatch, world);
    }
}
