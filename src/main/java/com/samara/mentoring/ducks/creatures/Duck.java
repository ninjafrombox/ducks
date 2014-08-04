package com.samara.mentoring.ducks.creatures;

import com.samara.mentoring.ducks.Coordinate;
import com.samara.mentoring.ducks.Direction;
import com.samara.mentoring.ducks.MovementType;
import com.samara.mentoring.ducks.world.Surface;
import com.samara.mentoring.ducks.world.WorldMap;

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
        Coordinate coordinate = worldMap.getNextCoordinate(position, direction);
        if(coordinate != null && worldMap.canMove(coordinate, movementType)) {
            position.change(coordinate.x(), coordinate.y());
        }
    }

    public Coordinate getCoordinate() {
        return position;
    }

    public Surface getSurface() {
        return worldMap.getSurface(position);
    }
}
