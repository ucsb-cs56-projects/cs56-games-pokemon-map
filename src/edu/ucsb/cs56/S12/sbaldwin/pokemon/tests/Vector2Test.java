package edu.ucsb.cs56.S12.sbaldwin.pokemon.tests;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.Vector2;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by William Bennett on 7/27/2016.
 */
public class Vector2Test {


    @Test public void testNoArgConstructor() {
        float x = 0;
        float y = 0;
        Vector2 vec = new Vector2();
        Assert.assertTrue(x == vec.x);
        Assert.assertTrue(y == vec.y);
    }

    @Test public void test2ArgConstructor() {
        float x = 1f;
        float y = 1f;
        Vector2 vec = new Vector2(x, y);
        Assert.assertTrue(vec.x == 1f && vec.y == 1f);
    }

    @Test public void testAdd() {
        Vector2 vec = new Vector2(1f, 1f);
        vec.add(1f, 1f);
        Assert.assertTrue(vec.x == 1f + 1f);
        Assert.assertTrue(vec.y == 1f + 1f);
    }

    @Test public void testSubtract() {
        Vector2 vec = new Vector2(1f, 1f);
        vec.sub(1f, 1f);
        Assert.assertTrue(vec.x == 0f);
        Assert.assertTrue(vec.y == 0f);
    }

    @Test public void testMult() {
        Vector2 vec = new Vector2(1f, 1f);
        vec = vec.mult(10f);
        Assert.assertTrue(vec.x == 1f * 10f);
        Assert.assertTrue(vec.y == 1f * 10f);
    }



}
