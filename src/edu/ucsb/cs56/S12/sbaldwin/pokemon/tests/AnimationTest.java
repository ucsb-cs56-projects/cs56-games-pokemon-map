package edu.ucsb.cs56.S12.sbaldwin.pokemon.tests;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Animation;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.AnimationFrame;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Texture;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by William Bennett on 7/27/2016.
 */
public class AnimationTest {
    private class DummyTexture extends Texture {
        int arrayPos;

        public DummyTexture(BufferedImage tileSheet, Rectangle bounds, int arrayPos) {
            super(tileSheet, bounds);
            this.arrayPos = arrayPos;
        }

        @Override
        public String toString() {
            return "DummyTexture{" +
                    "arrayPos=" + arrayPos +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DummyTexture that = (DummyTexture) o;

            return arrayPos == that.arrayPos;

        }

        @Override
        public int hashCode() {
            return arrayPos;
        }
    }

    public Texture dummyTexture(int pos) {
        return  new DummyTexture(new BufferedImage(10, 10, BufferedImage.TYPE_4BYTE_ABGR), new Rectangle(0, 0, 10, 10), pos);
    }

    public Texture[] dummyTexArray(int len) {
        Texture[] ret = new Texture[len];
        for (int i = 0; i < len; i++) {
            ret[i] = dummyTexture(i);
        }
        return ret;
    }

    public static Animation nFrameAnimation(Texture[] textures, float time) {
        int N = textures.length;
        AnimationFrame[] frames = new AnimationFrame[N];
        for (int i = 0; i < N; i++) {
            frames[i] = new AnimationFrame(textures[i], time);
        }
        return new Animation(frames);

    }

    @Test
    public void test1FrameAnimation() {
        Texture tex = dummyTexture(1);
        Animation animation = new Animation(tex);
        Assert.assertEquals(tex, animation.currentFrame());
        animation.advance(1);
        Assert.assertEquals(tex, animation.currentFrame());
    }

    @Test public void test2FrameAnimation() {
        Texture[] textures = dummyTexArray(2);
        Animation testAnimation = nFrameAnimation(textures, 1);
        testAnimation.run();
        testAnimation.advance(1.5f);
        Assert.assertEquals(textures[1], testAnimation.currentFrame());
    }

    @Test public void test3FrameAnimation() {
        Texture[] textures = dummyTexArray(3);
        Animation testAnimation = nFrameAnimation(textures, 1);
        testAnimation.run();
        testAnimation.advance(1.5f);
        testAnimation.advance(1f);
        Assert.assertEquals(textures[2], testAnimation.currentFrame());
    }

    @Test public void testFrameWrap() {
        Texture[] textures = dummyTexArray(3);
        Animation testAnimation = nFrameAnimation(textures, 1);
        // Advance 4.5 seconds
        testAnimation.run();
        testAnimation.advance(1.5f);
        testAnimation.advance(1f);
        testAnimation.advance(1f);
        testAnimation.advance(1f);
        Assert.assertEquals(textures[1], testAnimation.currentFrame());
    }


    @Test public void testFrameSkipping() {
        Texture[] textures = dummyTexArray(3);
        Animation testAnimation = nFrameAnimation(textures, 1);
        testAnimation.run();
        testAnimation.advance(2.5f);
        Assert.assertEquals(textures[2], testAnimation.currentFrame());
    }
}
