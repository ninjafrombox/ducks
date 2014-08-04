package com.samara.mentoring.ducks;

public class SimpleCoordinate implements Coordinate {
    private final int x;
    private final int y;

    public SimpleCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }
}
