package com.samara.mentoring.ducks.world;

import static com.samara.mentoring.ducks.MovementType.*;

import java.util.Arrays;
import java.util.Collection;

import com.samara.mentoring.ducks.MovementType;

public enum Surface {
    LAND(WALK),
    WATER(SWIM);

    private final Collection<MovementType> reachableBy;

    private Surface(MovementType... reachableBy) {
        this.reachableBy = Arrays.asList(reachableBy);
    }

    public boolean reachableBy(MovementType movementType) {
        return reachableBy.contains(movementType);
    }
}
