package edu.ucsb.cs56.S12.sbaldwin.pokemon;

/** The class for sprites of type tree
    @author Samuel Baldwin
    @author Marcus Liou
    @author Alec Harrell
    @author William Eiers
*/
class Tree extends StaticSprite {

    String treeType;

    /** 6 arg constructor
        @param x x position of the object
	    @param y y position of the object
	    @param width width of the object
	    @param height height of the object
	    @param id id of the sprite
	    @param treeType type of tree
	*/
	public Tree(int x, int y, int width, int height, int id, String treeType) {
        super(x,y,width,height,true,id);
        this.treeType = treeType;
        GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
        this.initializeTexture();
        this.updateSpritePosition(x,y);
        for(int i = 0; i < width; i++) {
        	for(int j = 0; j < height; j++) {
        		collisionValue[i][j] = GameGrid.GridValue.BLOCKED;
        	}
        }
    }

    /** Method for interacting with the trees
        NOT DONE YET
    */
	public void interact() {
	}

	/** Method to extract the sprite from the bitmap.
    */
	public void initializeTexture() {
        // room to add more. Since not many types of trees, simple switch statement
        // works well enough.
	    switch(treeType) {
        case "BASE_TREE_1":
            this.texture = new Texture("BaseTree", "TileSet_Main", 240, 3632, 256, 3664);
            break;
        case "NICE_TREE_1":
            this.texture = new Texture("NiceTree", "TileSet_Main", 192, 3696, 224, 3728);
            break;
        case "EVUL_TREE_1":
        	this.texture = new Texture("EvilTree", "TileSet_Main", 80,64,128,144);
	    }
	}

};
