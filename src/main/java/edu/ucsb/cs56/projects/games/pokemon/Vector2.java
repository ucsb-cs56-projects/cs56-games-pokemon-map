package edu.ucsb.cs56.projects.games.pokemon;

/**
 * Stores an x and y value to do vector operations
 *
 * @author Steven Fields
 */
public class Vector2 {

    public float x, y;

    public static final Vector2 zero = new Vector2(0, 0);

    /**
     * Constructs Vector2 at (0, 0)
     */
    public Vector2() {
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Constructs Vector2 at (x, y)
     *
     * @param x the x value
     * @param y the y value
     */
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /** 
     * Constructs a Vector2 at another Vector2 value
     *
     * @param v the Vector2
     */
    public Vector2(Vector2 v) {
        set(v);
    }

    /**
     * Set the x and y value
     *
     * @param x the x value
     * @param y the y value
     */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Set the x and y value from a Vector2
     *
     * @param v the Vector2
     */
    public void set(Vector2 v) {
        this.set(v.x, v.y);
    }

    /**
     * Adds a Vector2 on to this one
     *
     * @param v the Vector2
     */
    public void add(Vector2 v) {
        this.x += v.x;
        this.y += v.y;
    }

    /**
     * Adds an x and y value on to our vector
     *
     * @param x the x value
     * @param y the y value
     */
    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /**
     * Subtracts a Vector2 value from our vector
     * 
     * @param v the Vector2
     */
    public void sub(Vector2 v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    /**
     * Subtracts an x and y value from our vector
     *
     * @param x the x value
     * @param y the y value
     */
    public void sub(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    /**
     * Multiplies the vector by a scalar
     * 
     * @param value the scalar
     * @return a Vector2 multiplied by the scalar
     */
    public Vector2 mult(float value) {
        return new Vector2(x * value, y * value);
    }

    /**
     * Returns the dot product between this vector and another Vector2
     *
     * @param v the Vector2
     * @return the dot product between this and v
     */
    public float dot(Vector2 v) {
        return this.x * v.x + this.y * v.y;
    }

    /**
     * Returns the dot product between this vector and an x and y value
     *
     * @param x the x value
     * @param y the y value
     * @return the dot product between this, and x and y
     */
    public float dot(float x, float y) {
        return this.x * x + this.y * y;
    }

    /**
     * Returns the distance between two vectors' heads
     *
     * @param v the Vector2
     * @return the distance between the two vectors' heads
     */
    public double distance(Vector2 v) {
        float xd = v.x - x;
        float yd = v.y - y;
        return Math.sqrt(xd * xd + yd * yd);
    }

    /**
     * Returns the distance between this vector's head and an x and y value
     *
     * @param x the x value
     * @param y the y value
     * @return the distance between the vector's head and x and y
     */
    public double distance(float x, float y) {
        float xd = x - this.x;
        float yd = y - this.y;
        return Math.sqrt(xd * xd + yd * yd);
    }

    /**
     * Returns the cross product between this vector and another Vector2
     *
     * @param v the Vector2
     * @return the cross product between this and v
     */
    public float cross(Vector2 v) {
        return v.x * y - v.y * x;
    }

    /**
     * Returns the cross product between this vector and an x and y value
     *
     * @param x the x value
     * @param y the y value
     * @return the cross product between this, and x and y.
     */
    public float cross(float x, float y) {
        return x * this.y - y * this.x;
    }

    /**
     * Returns the angle of this vector from the x axis
     *
     * @return the angle from the x axis
     */
    public float angle() {
        double angle = Math.atan2(y, x);
        if (angle < 0)
            angle += Math.PI * 2;
        return (float)angle;
    }

    /**
     * Returns this vector as a string
     *
     * @return the vector as a string
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Returns a copy of this vector
     *
     * @return a copy of this vector
     */
    public Vector2 cpy() {
        return new Vector2(x, y);
    }

}
