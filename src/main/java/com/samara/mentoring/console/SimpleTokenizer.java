package com.samara.mentoring.console;

import java.util.LinkedList;
import java.util.List;

public class SimpleTokenizer implements InputTokenizer {
    private final String delimiterRegex;

    public SimpleTokenizer(String delimiterRegex) {
        this.delimiterRegex = delimiterRegex;
    }

    @Override
    public List<String> tokenize(String input) {
        List<String> result = new LinkedList<String>();
        for(String s : input.split(delimiterRegex)) {
            if(!s.isEmpty()) {
                result.add(s);
            }
        }
        return result;
    }
}
