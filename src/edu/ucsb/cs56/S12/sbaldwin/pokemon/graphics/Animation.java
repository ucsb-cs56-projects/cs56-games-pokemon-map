package edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by William Bennett on 7/15/2016.
 */
public class Animation {
    AnimationFrame[] animationFrames;
    float currentTime;
    int arrayPos;

    // Creates a static texture animation
    public Animation(Texture texture) {
        animationFrames = new AnimationFrame[1];
        animationFrames[0] = new AnimationFrame(texture);
    }

    public Animation(AnimationFrame[] animationList) {
        animationFrames = animationList;
    }

    public Texture currentFrame() {
        return animationFrames[arrayPos].texture;
    }

    public void advance(float timeDelta) {
        AnimationFrame currentFrame = animationFrames[arrayPos];
        currentTime += timeDelta;
        if (currentTime > currentFrame.frameLength) {
            arrayPos++;
            if (arrayPos >= animationFrames.length)
                arrayPos = 0;
            currentTime -= currentFrame.frameLength;
            advance(0f);
        }
    }


}
