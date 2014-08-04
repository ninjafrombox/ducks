package com.samara.mentoring.console;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jline.console.ConsoleReader;
import jline.console.UserInterruptException;
import jline.console.completer.StringsCompleter;

public class JlineConsole implements Console {
    private final Map<String,ConsoleCommand> commands = new HashMap<String,ConsoleCommand>();
    private final ConsoleReader reader;
    private final StringsCompleter completer;
    private final PrintWriter out;
    private final InputTokenizer tokenizer;
    private boolean isStarted = false;
    private String usage;

    public JlineConsole() {
        try {
            reader = new ConsoleReader();
            reader.setHandleUserInterrupt(true);
            completer = new StringsCompleter();
            reader.addCompleter(completer);
            out = new PrintWriter(reader.getOutput(), true);
            tokenizer = new SimpleTokenizer("\\s+");
        } catch (IOException e) {
            throw new ConsoleException(e);
        }
    }

    @Override
    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Override
    public void setPrompt(String prompt) {
        reader.setPrompt(prompt);
    }

    @Override
    public void registerCommand(String alias, ConsoleCommand command) {
        commands.put(alias, command);
    }

    @Override
    public void unregisterCommand(String alias) {
        if(commands.containsKey(alias)) {
            commands.remove(commands.get(alias));
        }
    }

    @Override
    public void start() throws ConsoleException {
        if(isStarted) throw new ConsoleException("Console has already been run");
        isStarted = true;
        completer.getStrings().clear();
        completer.getStrings().addAll(commands.keySet());
        String line;
        try {
            while(isStarted && (line = reader.readLine()) != null) {
                List<String> tokens = tokenizer.tokenize(line);
                String alias;
                if(!tokens.isEmpty() && (alias = tokens.get(0)) != null && commands.containsKey(alias)) {
                    tokens.remove(0);
                    commands.get(alias).perform(tokens);
                } else {
                    out.println(usage != null ? usage : "Unknown command, press TAB to list available ones");
                }
            }
        } catch (UserInterruptException e) {
            stop();
        } catch (IOException e) {
            throw new ConsoleException(e);
        }
    }

    @Override
    public void stop() throws ConsoleException {
        if(!isStarted) throw new ConsoleException("Console hasn't been run");
        isStarted = false;
        try {
            reader.getTerminal().reset();
        } catch (Exception e) {
            throw new ConsoleException(e);
        }
    }

    @Override
    public void println(String s) {
        out.println(s);
    }
}
