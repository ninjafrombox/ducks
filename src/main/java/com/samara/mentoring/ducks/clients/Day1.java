package com.samara.mentoring.ducks.clients;

import java.util.List;
import java.util.Random;

import com.samara.mentoring.console.Console;
import com.samara.mentoring.console.ConsoleCommand;
import com.samara.mentoring.console.JlineConsole;
import com.samara.mentoring.ducks.Coordinate;
import com.samara.mentoring.ducks.Direction;
import com.samara.mentoring.ducks.MovementCommand;
import com.samara.mentoring.ducks.SimpleCoordinate;
import com.samara.mentoring.ducks.creatures.Duck;
import com.samara.mentoring.ducks.world.RectangularWorldMap;
import com.samara.mentoring.ducks.world.Surface;

public class Day1 {
    private static final String CORE_MESSAGE = " param can be one of the following: UP, DOWN, LEFT, RIGHT";

    public static void createClient() {
        final Duck duck = createDuck(10,5);
        final Console console = new JlineConsole();
        console.setPrompt("> ");
        console.registerCommand("walk", new MovementCommand() {
            @Override protected void doMove(Direction direction) {
                duck.walk(direction);
            }
            @Override protected void badParamsMessage() {
                console.println("'walk'" + CORE_MESSAGE);
            }});
        console.registerCommand("swim", new MovementCommand() {
            @Override protected void doMove(Direction direction) {
                duck.swim(direction);
            }
            @Override protected void badParamsMessage() {
                console.println("'swim'" + CORE_MESSAGE);
            }});
        console.registerCommand("info", new ConsoleCommand() {
            @Override public void perform(List<String> params) {
                Coordinate coordinate = duck.getCoordinate();
                console.println("duck's coordinate is (" + coordinate.x() + ";" +
                        coordinate.y() + ")");
                console.println("current surface is " + duck.getSurface());
            }});
        console.registerCommand("exit", new ConsoleCommand() {
            @Override public void perform(List<String> params) {
                console.println("bye!");
                console.stop();
            }});
        console.start();
    }

    private static Duck createDuck(int width, int height) {
        Random rnd = new Random();
        Coordinate coordinate = new SimpleCoordinate(rnd.nextInt(width), rnd.nextInt(height));
        Surface[][] world = new Surface[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                world[i][j] = rnd.nextBoolean() ? Surface.LAND : Surface.WATER;
            }
        }
        return new Duck(coordinate, new RectangularWorldMap(world));
    }
}
