package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;

import java.util.ArrayList;

/**
 * A class to store and handle animation
 *
 * @author William Bennett
 */
public class Animation {
    AnimationFrame[] animationFrames;
    float currentTime;
    int arrayPos;
    boolean active = false;
    boolean looping = false;

    /**
     * Creates an animation with a single texture
     *
     * @param texture the texture
     */
    public Animation(Texture texture) {
        if (texture == null)
            throw new IllegalArgumentException("texture argument cannot be null");
        animationFrames = new AnimationFrame[1];
        animationFrames[0] = new AnimationFrame(texture);
        arrayPos = 0;
    }

    /**
     * Creates an animation from an array of frames
     *
     * @param animationList the array of frames
     */
    public Animation(AnimationFrame[] animationList) {
        if (animationList == null)
            throw new IllegalArgumentException("Animation list argument cannot be null");
        animationFrames = animationList;
        arrayPos = 0;
    }

    /**
     * Gives the current frame
     *
     * @return the current frame
     */
    public Texture currentFrame() {
        return animationFrames[arrayPos].texture;
    }

    /**
     * Moves the animation forward by a delta time
     *
     * @param timeDelta the delta time
     */
    public void advance(float timeDelta) {
        if (active) {
            AnimationFrame currentFrame = animationFrames[arrayPos];
            currentTime += timeDelta;
            if (currentTime > currentFrame.frameLength) {
                arrayPos++;
                if (arrayPos >= animationFrames.length) {
                    arrayPos = 0;
                    if (!looping)
                        active = false;
                }
                if (looping || arrayPos != 0) {
                    currentTime -= currentFrame.frameLength;
                    advance(0f);
                }
            }
        }
    }

    public void runOnce() {
        active = true;
    }

    public void run() {
        active = looping = true;
    }

    public void freeze() {
        active = looping = false;
    }

    public void halt() {
        looping = false;
    }


}
