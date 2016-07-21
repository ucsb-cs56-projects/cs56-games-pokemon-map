package edu.ucsb.cs56.S12.sbaldwin.pokemon.framework;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.SpriteBatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

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

    protected SpriteBatch spriteBatch;
    Toolkit toolkit;
    public MainWindow() {
        containerWindow = new JFrame();
        containerWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        containerWindow.setSize(width, height);

        containerWindow.getContentPane().add(BorderLayout.CENTER, this);

        containerWindow.setVisible(true);

        //setFocusable(true);

        toolkit = Toolkit.getDefaultToolkit();
        width = toolkit.getScreenSize().width;
        height = toolkit.getScreenSize().height;
        spriteBatch = new SpriteBatch(this.createImage(width, height));
    }

    public void run() {
        long currentTime = System.nanoTime();
        long deltaT = 0;
        load();
        init();
        initialized = true;
        while (running) {
            update(gameFrameTime);
            draw(spriteBatch, gameFrameTime);
            paintScreen(spriteBatch.getBackBuffer());
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

    private void paintScreen(Image backBuffer) {
        Graphics g;
        try {
            g = this.getGraphics();
            g.drawImage(backBuffer, 0, 0, null);
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }
        catch (Exception e) {
            System.err.println("Error getting graphics device");
        }
    }

    public void addKeyListener(KeyListener kl) {
        this.containerWindow.addKeyListener(kl);
    }
}
