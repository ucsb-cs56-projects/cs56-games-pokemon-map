package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Texture;

/**
 * Created by William Bennett on 7/14/2016.
 */

// This class contains information about a tile, based on its ID
// Stuff like collision behavior, etc. It's all loaded from a file and stored in a set
public class TileData {
    int tileID;
    Texture sprite;
    boolean collision; // Should be changed to an enum eventually

    public TileData(int tileID, Texture sprite, boolean collision) {
        this.tileID = tileID;
        this.sprite = sprite;
        this.collision = collision;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(tileID);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TileData) {
            TileData other = (TileData) o;
            return this.tileID == other.tileID;
        }
        return false;
    }
}
