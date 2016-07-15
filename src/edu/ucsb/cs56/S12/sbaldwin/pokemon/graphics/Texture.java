package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The class for objects of type Texture. Currently, texture objects are ones that dont cause collisions
 *
 * @author Samuel Baldwin
 * @author Marcus Liou
 * @author Alec Harrell
 */

public class Texture {
    BufferedImage tileSheet;
    Rectangle bounds;

    public Texture(BufferedImage tileSheet, Rectangle bounds) {
        this.tileSheet = tileSheet;
        this.bounds = bounds;
    }

    public Texture(BufferedImage tileSheet, int x, int y, int width, int height) {
        this.tileSheet = tileSheet;
        bounds = new Rectangle(x, y, width, height);
    }

    public BufferedImage getTileSheet() {
        return this.tileSheet;
    }

    public Rectangle srcRect() {
        return bounds;
    }

    public int width() {
        return bounds.width;
    }

    public int height() {
        return bounds.height;
    }

    public int srcX1() {
        return bounds.x;
    }

    public int srcX2() {
        return bounds.x + bounds.width;
    }

    public int srcY1() {
        return bounds.y;
    }

    public int srcY2() {
        return bounds.y + bounds.height;
    }
}
