package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** The class for generic houses of type building
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/
public class House extends Building {

    String houseType;

    /** 8 arg constructor
	    @param x x position of the object
	    @param y y position of the object
	    @param width width of the object
	    @param height height of the object
	    @param interactable indicate whether or not the object is interactable
	    @param id id of the sprite
	    @param interior true if interior exists, false otherwise
	    @param houseType type of house
	*/
	public House(int x, int y, int width, int height, boolean interactable, int id, boolean interior, String houseType) {
        super(x,y,width,height,interactable,id, interior);
        this.houseType = houseType;
        initializeTexture();
        GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
        this.updateSpritePosition(x,y);
	}

	/** Method for interacting with the House
        NOT USED YET
    */
	public void interact() {
	}

	/** Method to extract the sprite from the bitmap.
    */
	public void initializeTexture() {
	    // option to customize interior of house in switch statement
	    switch(houseType) {
        case "HOUSE_SMALL_1":
            this.texture = new Texture("SmallHouse", "TileSet_Main", 0, 1840, 80, 1888);
            break;
        case "HOUSE_MEDIUM_1":
            this.texture = new Texture("MediumHouse", "TileSet_Main", 0, 1888, 80, 1968);
            break;
        case "HOUSE_LARGE_1":
            this.texture = new Texture("LargeHouse", "TileSet_Main", 16, 1968, 128, 2048);
            break;
	    }
	}

	/** Method to build interior of a building
        NOT USED YET
    */
	public void buildInterior() {
	}
}
