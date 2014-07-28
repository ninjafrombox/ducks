package com.samara.mentoring.console;

public interface ConsoleCommand {
    /**
     * Parse params and perform action
     */
    void perform(String params);
}
