package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** The class for sprites of type building, i.e. PokeCenters, PokeMarts, trees and houses
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/

public abstract class Building extends StaticSprite {

    private boolean hasInterior;


    /** 7 arg constructor
	    @param x x position of the object
	    @param y y position of the object
	    @param width width of the object
	    @param height height of the object
	    @param interactable indicate whether or not the object is interactable
	    @param id id of the sprite
	    @param interior status of interior of building
	*/
	public Building(int x, int y, int width, int height, boolean interactable, int id, boolean interior) {
        super(x,y,width,height,interactable,id);
        hasInterior = interior;
        for(int i = 0; i < width; i++) {
        	for(int j = 0; j < height; j++) {
        		collisionValue[i][j] = GameGrid.GridValue.BLOCKED;
        	}
        }
	}

    /** Method to build interior of a building
        Must be implemented in subclasses
        NOT USED YET
    */
	public abstract void buildInterior();

	/** Setter for hasInterior
        @param interior true if there is an inside to the building, false otherwise
    */
	public void setHasInterior(boolean interior) {
        hasInterior = interior;
	}

	/** Getter for hasInterior
        @return true if there is an inside to the building, false otherwise
    */
	public boolean getHasInterior() {
        return hasInterior;
	}
}
