package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The class for objects of type Texture.
 *
 * @author Steven Fields
 * @author William Bennett
 */

public class Texture {
    BufferedImage tileSheet;
    Rectangle bounds;

    /**
     * Creates a texture from a tile sheet and a rectangle of its position
     *
     * @param tileSheet the tile sheet
     * @param bounds the bounds of the texture
     */
    public Texture(BufferedImage tileSheet, Rectangle bounds) {
        this.tileSheet = tileSheet;
        this.bounds = bounds;
    }

    /**
     * Creates a texture from a tile sheet and its x, y value on the sheet, and its width and height
     *
     * @param tileSheet the tile sheet
     * @param x the x value
     * @param y the y value
     * @param width the width
     * @param height the height
     */
    public Texture(BufferedImage tileSheet, int x, int y, int width, int height) {
        this.tileSheet = tileSheet;
        bounds = new Rectangle(x, y, width, height);
    }

    /**
     * Returns the tile sheet
     *
     * @return the tile sheet
     */
    public BufferedImage getTileSheet() {
        return this.tileSheet;
    }

    /**
     * Returns the bounds of the texture
     *
     * @return the bounds
     */
    public Rectangle srcRect() {
        return bounds;
    }

    /**
     * Returns the width
     *
     * @return the width
     */
    public int width() {
        return bounds.width;
    }

    /**
     * Returns the height
     *
     * @return height
     */
    public int height() {
        return bounds.height;
    }

    /**
     * Returns the x coordinate in the left of the texture
     *
     * @return the first x value
     */
    public int srcX1() {
        return bounds.x;
    }

    /**
     * Returns the x coordinate on the right of the texture
     *
     *  @return the second x value
     */
    public int srcX2() {
        return bounds.x + bounds.width;
    }

    /**
     * Returns the y value on the top of the texture
     *
     * @return the first y value
     */
    public int srcY1() {
        return bounds.y;
    }

    /**
     * Returns the y value on the bottom of the texture
     *
     * @return the second y value
     */
    public int srcY2() {
        return bounds.y + bounds.height;
    }
}
