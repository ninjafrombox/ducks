package com.samara.mentoring.ducks;

import java.util.List;

import com.samara.mentoring.console.ConsoleCommand;

public abstract class MovementCommand implements ConsoleCommand {
    @Override
    public void perform(List<String> params) {
       if(params.isEmpty()) {
           badParamsMessage();
           return;
       }
       try {
           Direction direction = Direction.valueOf(params.get(0).toUpperCase());
           doMove(direction);
       } catch(IllegalArgumentException e) {
           badParamsMessage();
       }
    }

    protected abstract void doMove(Direction direction);

    protected abstract void badParamsMessage();
}
