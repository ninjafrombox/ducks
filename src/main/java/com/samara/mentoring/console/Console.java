package com.samara.mentoring.console;

public interface Console {
    void setUsage(String usage);
    void setPrompt(String prompt);
    void registerCommand(String alias, ConsoleCommand command);
    void unregisterCommand(String alias);
    void start() throws ConsoleException;
    void stop() throws ConsoleException;
    void println(String s);
}
