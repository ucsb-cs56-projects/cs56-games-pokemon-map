package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by William Bennett on 6/30/2016.
 */
public class SpriteBatch extends JPanel {
    boolean drawBegin = false;
    BufferedImage drawBuffer;
    Graphics graphics;
    public SpriteBatch(int width, int height) {
        drawBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphics = drawBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(drawBuffer, 0, 0, null);
    }

    public void begin() {
        if (!drawBegin)
            drawBegin = true;
        else
            throw new RuntimeException("SpriteBatch.begin was called between begin and end calls");
    }

    public void draw(Texture texture, Point position) {
        graphics.drawImage(texture.getTileSheet(),
                texture.srcX1(), texture.srcY1(), texture.srcX2(), texture.srcY2(),
                position.x, position.y, position.x + texture.width(), position.y + texture.height(), null);
    }

    public void end() {
        drawBegin = false;
        this.repaint();
    }

    public void clear(Color color) {
        graphics.setColor(color);
        graphics.drawRect(0, 0, drawBuffer.getWidth(), drawBuffer.getHeight());
    }

    public int width() {return drawBuffer.getWidth();}

    public int height() {return drawBuffer.getHeight();}
}
