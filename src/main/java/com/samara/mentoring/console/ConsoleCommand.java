package com.samara.mentoring.console;

import java.util.List;

public interface ConsoleCommand {
    void perform(List<String> params);
}
