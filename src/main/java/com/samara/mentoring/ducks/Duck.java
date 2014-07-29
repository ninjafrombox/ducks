package com.samara.mentoring.ducks;


public class Duck {
    private final Position position;
    private final WorldMap worldMap;

    public Duck(Coordinate coordinate, WorldMap worldMap) {
        position = new Position(coordinate);
        this.worldMap = worldMap;
    }

    public void walk(Direction direction) {
        move(direction, MovementType.WALK);
    }

    public void swim(Direction direction) {
        move(direction, MovementType.SWIM);
    }

    private void move(Direction direction, MovementType movementType) {
        if(worldMap.canMove(position, movementType, direction)) {
            Coordinate coordinate = worldMap.getNextCoordinate(position, direction);
            position.change(coordinate.x(), coordinate.y());
        }
    }

    public Coordinate getCoordinate() {
        return position;
    }
}
