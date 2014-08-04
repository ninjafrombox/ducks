package com.samara.mentoring.ducks.world;

import com.samara.mentoring.ducks.Coordinate;
import com.samara.mentoring.ducks.Direction;
import com.samara.mentoring.ducks.MovementType;

public interface WorldMap {
    /**
     * @return null if movement to direction is impossible
     */
    Coordinate getNextCoordinate(Coordinate from, Direction direction);
    boolean canMove(Coordinate to, MovementType movementType);
    /**
     * @return null if coordinate is out of the world
     */
    Surface getSurface(Coordinate coordinate);
}
