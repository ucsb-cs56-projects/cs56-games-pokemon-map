package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Texture;

/**
 * Class to contain TileData
 *
 * @author William Bennett
 */

// This class contains information about a tile, based on its ID
// Stuff like collision behavior, etc. It's all loaded from a file and stored in a set
public class TileData {
    int tileID;
    Texture sprite;
    boolean collision; // Should be changed to an enum eventually

    /**
     * Main constructor for tile data
     *
     * @param tileID the id number for the tile
     * @param sprite the texture for the tile
     * @param collision whether the tile is walkable on or not
     */
    public TileData(int tileID, Texture sprite, boolean collision) {
        this.tileID = tileID;
        this.sprite = sprite;
        this.collision = collision;
    }
    
    /**
     * Overrides the hashCode method of Object to return the hashCode of the tileID
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(tileID);
    }

    /**
     * Overrides the equal method of Object to check if the tileID is the same
     * 
     * @param o the Object to compare
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof TileData) {
            TileData other = (TileData) o;
            return this.tileID == other.tileID;
        }
        return false;
    }
}
