package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.IO.MapLoader;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.framework.MainWindow;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.SpriteBatch;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.systems.RenderSystem;

import java.awt.*;

/**
 * Created by William Bennett on 7/14/2016.
 * Put ALL game logic in this class, or in objects rooted in this class
 */
public class Game extends MainWindow {
    private static String testMap = "map_name {" +
            "width:4        height:4" +
            "[0, 0, 0], [0, 1, 0], [0, 2, 0], [0, 3, 0], [0, 0, 1], [0, 1, 1],[0, 2, 1], [0, 3, 1]," +
            "[0, 0, 2], [0, 1, 2], [0, 2, 2], [0, 3, 2], [0, 0, 3], [0, 1, 3],[0, 2, 3], [0, 3, 3]," +
            "}";

    World world;
    RenderSystem renderSystem;
    public Game() {
        super();
    }

    public void init() {
	// create world
	//
        super.init();
        InputHandler inputHandler = new InputHandler();
        this.addKeyListener(inputHandler);
        world = new World(inputHandler);
        renderSystem = new RenderSystem(this.getBounds());
        MapLoader ml = new MapLoader();
        ml.loadMap(testMap, world);
    }

    public void load() {
	// load assets
        super.load();
        Assets.initAssets();
    }

    public void update(float gameTime) {
        super.update(gameTime);
        world.update();
    }

    public void draw(SpriteBatch spriteBatch, float gameTime) {
        super.draw(spriteBatch, gameTime);
	    renderSystem.draw(spriteBatch, world);
    }
}
