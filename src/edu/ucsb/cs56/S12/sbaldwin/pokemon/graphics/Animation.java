package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;

import java.util.ArrayList;

/**
 * Created by William Bennett on 7/15/2016.
 */
public class Animation {
    AnimationFrame[] animationFrames;
    float currentTime;
    int arrayPos;
    boolean active = false;
    boolean looping = false;

    // Creates a static texture animation
    public Animation(Texture texture) {
        if (texture == null)
            throw new IllegalArgumentException("texture argument cannot be null");
        animationFrames = new AnimationFrame[1];
        animationFrames[0] = new AnimationFrame(texture);
        arrayPos = 0;
    }

    public Animation(AnimationFrame[] animationList) {
        if (animationList == null)
            throw new IllegalArgumentException("Animation list argument cannot be null");
        animationFrames = animationList;
        arrayPos = 0;
    }

    public Texture currentFrame() {
        return animationFrames[arrayPos].texture;
    }

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
