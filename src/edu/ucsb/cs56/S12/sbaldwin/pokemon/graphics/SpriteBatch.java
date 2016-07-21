package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by William Bennett on 6/30/2016.
 */
public class SpriteBatch {
    Graphics2D drawBuffer;
    Image backBuffer;

    public SpriteBatch(Image image) {
        this.backBuffer = image;
        this.drawBuffer = (Graphics2D)backBuffer.getGraphics();
    }

    void draw(BufferedImage image) {
        drawBuffer.drawImage(image, 0, 0, null);
    }

    public void draw(Texture texture, Point position) {
        drawBuffer.drawImage(texture.getTileSheet().getSubimage(texture.srcX1(), texture.srcY1(), texture.width(), texture.height()), null, position.x, position.y);
    }

    public void draw(Texture texture, Rectangle destRect) {
        drawBuffer.drawImage(texture.getTileSheet().getSubimage(texture.srcX1(), texture.srcY1(), texture.width(), texture.height()), null, destRect.x, destRect.y);
    }

    public Image getBackBuffer() {
        return backBuffer;
    }
}
