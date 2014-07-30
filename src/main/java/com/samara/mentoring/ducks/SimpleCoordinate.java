package com.samara.mentoring.ducks;

public class SimpleCoordinate implements Coordinate {
    private final int x;
    private final int y;

    /**
     * Arguments must be nonnegative
     */
    public SimpleCoordinate(int x, int y) {
        if(x < 0 || y < 0) throw new IllegalArgumentException("Coordinates must be nonnegative");
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
