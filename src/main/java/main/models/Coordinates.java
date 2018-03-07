package main.models;

public class Coordinates {

    private Float x;
    private Float y;

    private Coordinates(){}

    public Coordinates(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }
}
