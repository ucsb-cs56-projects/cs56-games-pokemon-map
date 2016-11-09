package edu.ucsb.cs56.projects.games.pokemon.graphics;


/**
 * A single animation frame
 *
 * @author William Bennett
 */
public class AnimationFrame {
    public final Texture texture;
    public final float frameLength;

    /**
     * Creates an animation frame from a texture, assumes 1 frame length long
     *
     * @param texture the texture
     */
    public AnimationFrame(Texture texture) {
        this.texture = texture;
        this.frameLength = 1f;
    }

    /**
     * Creates an animation frame from a texture and a frame length
     *
     * @param texture the texture
     * @param frameLength the frame length
     */
    public AnimationFrame(Texture texture, float frameLength) {
        this.texture = texture;
        this.frameLength = frameLength;
    }

    /**
     * Checks if two Animation frames are equal dependent on their texture and frame length
     *
     * @param o the AnimationFrame
     * @return if the two frames are equal
     */
    public boolean equals(Object o) {
        if (o instanceof AnimationFrame) {
            AnimationFrame a = (AnimationFrame) o;
            return (this.texture == a.texture && this.frameLength == a.frameLength);
        }
        return false;
    }

    /**
     * Returns a unique hash code for a animation frame
     *
     * @return a hash code
     */
    public int hashCode() {
        return texture.hashCode() ^ Float.hashCode(frameLength);
    }
}
