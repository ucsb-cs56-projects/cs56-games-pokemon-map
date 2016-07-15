package edu.ucsb.cs56.S12.sbaldwin.pokemon.systems;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 * Created by William Bennett on 6/30/2016.
 */
public class RenderSystem {
    HashMap<String, BufferedImage> spriteSheets;

    public RenderSystem() {
        spriteSheets = new HashMap<String, BufferedImage>();
    }

    public Texture createTexture(String spritesheet, Rectangle bounds) {
        return new Texture(spriteSheets.get(spritesheet), bounds);
    }

    public void loadImages(String[] imageNames) {
        for (String name : imageNames) {
            try {
                spriteSheets.put(name, ImageIO.read(new File(name)));
            }
            catch (IOException e) {
                System.err.println("Image " + name + " not found");
                System.err.println("At stacktrace:");
                e.printStackTrace(System.err);
            }
        }
    }
}
