package main.java.edu.ucsb.cs56.projects.games.pokemon.graphics;

import main.java.edu.ucsb.cs56.projects.games.pokemon.components.MovementComponent;

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
    boolean active;
    boolean looping;

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
        active = true;
        looping = true;
        currentTime = 0;
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
     * @param direction the direction the character is moving
     */
    public void advance(float timeDelta, MovementComponent direction) {
        if (active) {
            AnimationFrame currentFrame = animationFrames[arrayPos];
            currentTime += timeDelta;
            if (currentTime > currentFrame.frameLength) {
                if (direction.getDirection() == MovementComponent.Direction.South) {
                    if (arrayPos == 0) {
                        arrayPos = 1;
                    }

                    else if (arrayPos == 1) {
                        arrayPos = 2;
                    }
                    else if (arrayPos == 2) {
                        arrayPos = 0;
                    }
                    else {
                        arrayPos = 0;
                    }

                }

                else if (direction.getDirection() == MovementComponent.Direction.North) {
                    if (arrayPos == 3) {
                        arrayPos = 4;
                    }
                    else if (arrayPos == 4) {
                        arrayPos = 5;
                    }
                    else if (arrayPos == 5) {
                        arrayPos = 3;
                    }
                    else {
                        arrayPos = 3;
                    }
                }
                else if (direction.getDirection() == MovementComponent.Direction.East) {
                    if (arrayPos == 6) {
                        arrayPos = 7;
                    }
                    else if (arrayPos == 7) {
                        arrayPos = 8;
                    }
                    else if (arrayPos == 8) {
                        arrayPos = 6;
                    }
                    else {
                        arrayPos = 6;
                    }
                }
                else if (direction.getDirection() == MovementComponent.Direction.West) {
                    if (arrayPos == 9) {
                        arrayPos = 10;
                    }
                    else if (arrayPos == 10) {
                        arrayPos = 11;
                    }
                    else if (arrayPos == 11) {
                        arrayPos = 9;
                    }
                    else {
                        arrayPos = 9;
                    }
                }
                if (arrayPos >= animationFrames.length) {
                    arrayPos = 0;
                    if (!looping)
                        active = false;
                }
                if (looping || arrayPos != 0) {
                    currentTime -= currentFrame.frameLength;
                    advance(0.00f, direction);
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
