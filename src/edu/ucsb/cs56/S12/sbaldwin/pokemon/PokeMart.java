package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** The class for buildings of type pokemart
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/

public class PokeMart extends Building {

    /** 7 arg constructor
	    @param x x position of the object
	    @param y y position of the object
	    @param width width of the object
	    @param height height of the object
	    @param interactable indicate whether or not the object is interactable
	    @param id id of the sprite
	    @param interior true if interior exists, false otherwise
	*/
	public PokeMart(int x, int y, int width, int height, boolean interactable, int id, boolean interior) {
        super(x,y,width,height,interactable,id, interior);
        initializeTexture();
        GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
        this.updateSpritePosition(x,y);
	}

	/** Method for interacting with the PokeMart
        NOT USED YET
    */
	public void interact() {
	}

	/** Method to extract the sprite from the bitmap.
    */
	public void initializeTexture() {
	    this.texture = new Texture("PokeMart", "TileSet_Main", 0, 656, 64, 720);
	}

	/** Method to build interior of a building
        NOT USED YET
    */
	public void buildInterior() {
	}
}
