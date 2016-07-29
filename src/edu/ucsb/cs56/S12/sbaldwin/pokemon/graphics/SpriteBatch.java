package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A sprite batch to handle drawing
 *
 * @author William Bennett
 */
public class SpriteBatch {
    Graphics2D drawBuffer;
    Image backBuffer;

    /**
     * Creates a sprite batch with a image
     *
     * @param image the image
     */
    public SpriteBatch(Image image) {
        this.backBuffer = image;
        this.drawBuffer = (Graphics2D)backBuffer.getGraphics();
    }

    /**
     * Draws a bufferedImage to the screen
     *
     * @param image the BufferedImage
     */
    void draw(BufferedImage image) {
        drawBuffer.drawImage(image, 0, 0, null);
    }

    /**
     * Draws a texture to the screen at a specific position
     *
     * @param texture the texture
     * @param position the position
     */
    public void draw(Texture texture, Point position) {
        drawBuffer.drawImage(texture.getTileSheet().getSubimage(texture.srcX1(), texture.srcY1(), texture.width(), texture.height()), null, position.x, position.y);
    }

    /**
     * Draws a texture to the screen at a specific rectangle
     *
     * @param texture the texture
     * @param destRect the rectangle
     */
    public void draw(Texture texture, Rectangle destRect) {
        drawBuffer.drawImage(texture.getTileSheet().getSubimage(texture.srcX1(), texture.srcY1(), texture.width(), texture.height()), null, destRect.x, destRect.y);
    }

    /**
     * Retrieves the image in the back buffer
     *
     * @return the backBuffer
     */
    public Image getBackBuffer() {
        return backBuffer;
    }
}
