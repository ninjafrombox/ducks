package com.samara.mentoring.console;

public class ConsoleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ConsoleException(String message) {
        super(message);
    }

    public ConsoleException(Throwable cause) {
        super(cause);
    }
}
