package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.imageio.ImageIO;
import javax.management.timer.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

/** The window frame for the Pokemon map game
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
*/
public class MainWindow extends JPanel
{
    boolean running = true;
    int width;
    int height;
    static final long maxTime = 16666;
    BufferedImage image;
    public MainWindow(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0, 0, width, height);
        draw(g);
    }

    public void run() {
        long currentTime = System.nanoTime();
        long deltaT = 0;
        init();
        load();

        while (running) {
            update();
            repaint();
            deltaT = System.nanoTime() - currentTime;
            try {
                Thread.sleep(Math.max((maxTime - deltaT) / 1000, 0));
            }
            catch (InterruptedException e) {
                System.err.println("Thread interupted");
            }
            currentTime = System.nanoTime();
        }
    }

    private void init() {

    }

    private void load() {
        try {
            image = ImageIO.read(new File("assets/images/TileSet.bmp"));
        }
        catch (IOException e) {
            System.err.println("Failed to load image");
        }
    }

    private void update() {

    }

    private void draw(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
