package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.commands.Command;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.commands.InteractCommand;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.commands.MoveCommand;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.components.PositionComponent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by steven on 6/30/16.
 */
public class InputHandler implements KeyListener {

    public boolean[] keys;
    public MoveCommand moveCommand;

    public InputHandler() {
        keys = new boolean[5];
    }

    public void updateMovement(PositionComponent positionComponent) {
        Point moveTo = (Point) positionComponent.position.clone();
        if (keys[0]) {
            moveTo.move(0, -1);
        } else if (keys[1]) {
            moveTo.move(0, 1);
        } else if (keys[2]) {
            moveTo.move(-1, 0);
        } else if (keys[3]) {
            moveTo.move(1, 0);
        } else {
            return;
        }
        moveCommand = new MoveCommand(positionComponent, moveTo);
    }

    public Command updateInteract(PositionComponent positionComponent, World world) {
        if (keys[4]) {
            return new InteractCommand(positionComponent, world);
        }
        return null;
    }

    /**
     * Checks if a key is pressed, then set that in the boolean array
     *
     * @param e the KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                keys[0] = true;
                break;
            case KeyEvent.VK_S:
                keys[1] = true;
                break;
            case KeyEvent.VK_A:
                keys[2] = true;
                break;
            case KeyEvent.VK_D:
                keys[3] = true;
                break;
            case KeyEvent.VK_H:
                keys[4] = true;
                break;
            default:
                break;
        }
    }

    /**
     * Checks if a key is released, then set that in the boolean array
     *
     * @param e the KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                keys[0] = false;
                break;
            case KeyEvent.VK_S:
                keys[1] = false;
                break;
            case KeyEvent.VK_A:
                keys[2] = false;
                break;
            case KeyEvent.VK_D:
                keys[3] = false;
                break;
            case KeyEvent.VK_H:
                keys[4] = false;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {


    }


}
