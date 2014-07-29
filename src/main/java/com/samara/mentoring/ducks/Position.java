package com.samara.mentoring.ducks;


public class Position implements Coordinate {
    private int x;
    private int y;

    public Position(Coordinate coordinate) {
        change(coordinate.x(), coordinate.y());
    }

    public Position(int x, int y) {
        change(x, y);
    }

    public void change(int x, int y) {
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
