package edu.ucsb.cs56.S12.sbaldwin.pokemon;

public class Vector2 {

    public float x, y;

    public Vector2() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 v) {
        set(v);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2 v) {
        this.set(v.x, v.y);
    }

    public void add(Vector2 v) {
        this.x += v.x;
        this.y += v.y;
    }

    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void sub(Vector2 v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    public void sub(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public float dot(Vector2 v) {
        return this.x * v.x + this.y * v.y;
    }

    public float dot(float x, float y) {
        return this.x * x + this.y * y;
    }

    public double distance(Vector2 v) {
        float xd = v.x - x;
        float yd = v.y - y;
        return Math.sqrt(xd * xd + yd * yd);
    }

    public double distance(float x, float y) {
        float xd = x - this.x;
        float yd = y - this.y;
        return Math.sqrt(xd * xd + yd * yd);
    }

    public float cross(Vector2 v) {
        return v.x * y - v.y * x;
    }

    public float cross(float x, float y) {
        return x * this.y - y * this.x;
    }

    public double angle() {
        double angle = Math.atan2(y, x);
        if (angle < 0)
            angle += 360;
        return angle;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Vector2 cpy() {
        return new Vector2(x, y);
    }

}
