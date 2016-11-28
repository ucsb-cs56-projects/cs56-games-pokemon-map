package edu.ucsb.cs56.projects.games.pokemon;

import edu.ucsb.cs56.projects.games.pokemon.IO.MapLoader;
import edu.ucsb.cs56.projects.games.pokemon.framework.MainWindow;
import edu.ucsb.cs56.projects.games.pokemon.graphics.SpriteBatch;
import edu.ucsb.cs56.projects.games.pokemon.systems.MovementSystem;
import edu.ucsb.cs56.projects.games.pokemon.systems.RenderSystem;
import edu.ucsb.cs56.projects.games.pokemon.systems.SystemMessenger;
import edu.ucsb.cs56.projects.games.pokemon.IO.ReadFile;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Put ALL game logic in this class, or in objects rooted in this class
 *
 * @author William Bennett
 */
public class Game extends MainWindow {
    private static String testMap = setTestMap("src/edu/ucsb/cs56/projects/games/pokemon/maps/Pond_Map.txt");


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

    /**
     *
     * @param map file destination in folders
     * @return String data to be loaded into parser for map creation
     */

    public static String setTestMap(String map) {
        String output = new String();
        output = "";
        try {
            output = ReadFile.readFile(map, Charset.defaultCharset());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return output;
    }
}
