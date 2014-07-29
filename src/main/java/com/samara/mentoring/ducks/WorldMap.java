package com.samara.mentoring.ducks;

public interface WorldMap {
    boolean canMove(Coordinate from, MovementType movementType, Direction direction);
    Coordinate getNextCoordinate(Coordinate from, Direction direction);
}
