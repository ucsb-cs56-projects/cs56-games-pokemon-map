package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by William Bennett on 6/30/2016.
 */
public class SpriteBatch {
    Graphics graphicsDevice;
    public SpriteBatch(Graphics graphicsDevice) {
        this.graphicsDevice = graphicsDevice;
    }

    void draw(BufferedImage image) {
        graphicsDevice.drawImage(image, 0, 0, null);
    }

    public void draw(Texture texture, Point position) {
            graphicsDevice.drawImage(texture.getTileSheet(),
                texture.srcX1(), texture.srcY1(), texture.srcX2(), texture.srcY2(),
                position.x, position.y, position.x + texture.width(), position.y + texture.height(), null);
    }

    public void draw(Texture texture, Rectangle destRect) {
            graphicsDevice.drawImage(texture.getTileSheet(),
                    texture.srcX1(), texture.srcY1(), texture.srcX2(), texture.srcY2(),
                    destRect.x, destRect.y, destRect.x + destRect.width, destRect.y + destRect.height, null);
    }
}
