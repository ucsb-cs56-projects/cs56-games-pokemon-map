package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;


/**
 * Created by William Bennett on 7/15/2016.
 */
public class AnimationFrame {
    public final Texture texture;
    public final float frameLength;

    public AnimationFrame(Texture texture) {
        this.texture = texture;
        this.frameLength = 1f;
    }

    public AnimationFrame(Texture texture, float frameLength) {
        this.texture = texture;
        this.frameLength = frameLength;
    }

    public boolean equals(Object o) {
        if (o instanceof AnimationFrame) {
            AnimationFrame a = (AnimationFrame) o;
            return (this.texture == a.texture && this.frameLength == a.frameLength);
        }
        return false;
    }

    public int hashCode() {
        return texture.hashCode() ^ Float.hashCode(frameLength);
    }
}
