package com.samara.mentoring.ducks.world;

import com.samara.mentoring.ducks.Coordinate;
import com.samara.mentoring.ducks.Direction;
import com.samara.mentoring.ducks.MovementType;
import com.samara.mentoring.ducks.SimpleCoordinate;

public class RectangularWorldMap implements WorldMap {
    private final Surface[][] world;
    private final int width;
    private final int height;

    /**
     * Argument must be regular array
     */
    public RectangularWorldMap(Surface[][] world) {
        this.world = world;
        height = world.length;
        width = height == 0 ? 0 : world[0].length;
        for(Surface[] line : world) {
            if(line.length != width) throw new IllegalArgumentException("Irregular array isn't allowed");
        }
    }

    @Override
    public Coordinate getNextCoordinate(Coordinate from, Direction direction) {
        Coordinate coordinate = null;
        if(direction == Direction.UP) coordinate = new SimpleCoordinate(from.x(), from.y() + 1);
        if(direction == Direction.DOWN) coordinate = new SimpleCoordinate(from.x(), from.y() - 1);
        if(direction == Direction.LEFT) coordinate = new SimpleCoordinate(from.x() - 1, from.y());
        if(direction == Direction.RIGHT) coordinate = new SimpleCoordinate(from.x() + 1, from.y());
        return (coordinate != null && isInsideWorld(coordinate)) ? coordinate : null;
    }

    @Override
    public boolean canMove(Coordinate to, MovementType movementType) {
        return isInsideWorld(to) && world[to.y()][to.x()].reachableBy(movementType);
    }

    private boolean isInsideWorld(Coordinate coordinate) {
        return coordinate.x() >= 0 && coordinate.x() < width && coordinate.y() >= 0 && coordinate.y() < height;
    }
}
