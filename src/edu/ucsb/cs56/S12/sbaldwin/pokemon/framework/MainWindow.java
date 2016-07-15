package edu.ucsb.cs56.S12.sbaldwin.pokemon.framework;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.SpriteBatch;

import javax.swing.*;
import java.awt.*;

/**
 * The window frame for the Pokemon map game
 *
 * @author William Bennett
 */
public class MainWindow extends JPanel {
    boolean running = true;
    int width = 640;
    int height = 480;
    static final long maxTime = 16666;
    static final float gameFrameTime = 16.666f;

    private JFrame containerWindow;
    volatile private boolean initialized = false;

    public MainWindow() {
        containerWindow = new JFrame();
        containerWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        containerWindow.setSize(width, height);

        containerWindow.getContentPane().add(BorderLayout.CENTER, this);

        containerWindow.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0, 0, width, height);
        if (initialized)
            draw(new SpriteBatch(g), gameFrameTime);
    }

    public void run() {
        long currentTime = System.nanoTime();
        long deltaT = 0;
        load();
        init();
        initialized = true;
        while (running) {
            update(gameFrameTime);
            repaint();
            deltaT = System.nanoTime() - currentTime;
            try {
                Thread.sleep(Math.max((maxTime - deltaT) / 1000, 0));
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted");
            }
            currentTime = System.nanoTime();
        }
    }

    protected void init() {
    }

    protected void load() {
    }

    protected void update(float gameTime) {

    }

    protected void draw(SpriteBatch spriteBatch, float gameTime) {
        if (!initialized)
            return;
    }
}
