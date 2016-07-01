package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by steven on 6/30/16.
 */
public class InputHandler implements KeyListener {

    boolean[] keys;

    public void InputHandler() {
        keys = new boolean[5];
    }

    public void update() {
        if (keys[0]) {
            // move up
        } else if (keys[1]) {
            // move down
        } else if (keys[2]) {
            // move left
        } else if (keys[3]) {
            // move right
        } else {
            // don't move
        }
        if(keys[4]) {
            // interact
        }
    }

    /** Notifies GameLogic that a key has been pressed
     @param e the KeyEvent
     */
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_W : keys[0] = true; break;
            case KeyEvent.VK_S : keys[1] = true; break;
            case KeyEvent.VK_A : keys[2] = true; break;
            case KeyEvent.VK_D : keys[3] = true; break;
            case KeyEvent.VK_H : keys[4] = true; break;
            default: break;
        }
    }

    /** Notifies GameLogic that a key has been released
     @param e the KeyEvent
     */
    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_W : keys[0] = false; break;
            case KeyEvent.VK_S : keys[1] = false; break;
            case KeyEvent.VK_A : keys[2] = false; break;
            case KeyEvent.VK_D : keys[3] = false; break;
            case KeyEvent.VK_H : keys[4] = false; break;
            default: break;
        }
    }



    public void keyTyped(KeyEvent e)
    {


    }


}
