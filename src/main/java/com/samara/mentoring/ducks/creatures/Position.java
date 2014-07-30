package com.samara.mentoring.ducks.creatures;

import com.samara.mentoring.ducks.Coordinate;

class Position implements Coordinate {
    private int x;
    private int y;

    Position(Coordinate coordinate) {
        change(coordinate.x(), coordinate.y());
    }

    Position(int x, int y) {
        change(x, y);
    }

    void change(int x, int y) {
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
