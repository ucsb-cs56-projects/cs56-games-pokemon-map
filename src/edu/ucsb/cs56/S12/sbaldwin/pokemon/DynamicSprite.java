package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/** Subclass of Sprite, for sprites that change over time
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/

public abstract class DynamicSprite extends Sprite {

    /** 6 arg constructor
        @param x x position of the object
	    @param y y position of the object
	    @param width width of the object
	    @param height height of the object
	    @param interactable indicate whether or not the object is interactable
	    @param id id of the sprite
	*/
	public DynamicSprite(int x, int y, int width, int height, boolean interactable, int id) {
        super(x,y,width,height,interactable,id);
    }
}
