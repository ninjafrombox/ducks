package com.samara.mentoring.ducks;

import com.samara.mentoring.console.Console;
import com.samara.mentoring.console.ConsoleCommand;
import com.samara.mentoring.console.JlineConsole;

public class Main {
    public static void main(String[] args) {
        final Console console = new JlineConsole();
        console.registerCommand("foo", new ConsoleCommand() {
            @Override public void perform(String params) {
                console.println("foo command invoked");
            }});
        console.registerCommand("bar", new ConsoleCommand() {
            @Override public void perform(String params) {
                console.println("bar command invoked");
            }});
        console.registerCommand("finish", new ConsoleCommand() {
            @Override public void perform(String params) {
                console.println("bye!");
                console.stop();
            }});
        console.start();
    }
}
