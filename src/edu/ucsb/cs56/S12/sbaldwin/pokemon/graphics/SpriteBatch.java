package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by William Bennett on 6/30/2016.
 */
public class SpriteBatch {
    Graphics2D graphics2D;

    public SpriteBatch(Graphics graphicsDevice) {
        this.graphics2D = (Graphics2D) graphicsDevice;
    }

    void draw(BufferedImage image) {
        graphics2D.drawImage(image, 0, 0, null);
    }

    public void draw(Texture texture, Point position) {
        graphics2D.drawImage(texture.getTileSheet().getSubimage(texture.srcX1(), texture.srcY1(), texture.width(), texture.height()), null, position.x, position.y);
    }

    public void draw(Texture texture, Rectangle destRect) {
        graphics2D.drawImage(texture.getTileSheet().getSubimage(texture.srcX1(), texture.srcY1(), texture.width(), texture.height()), null, destRect.x, destRect.y);
    }
}
