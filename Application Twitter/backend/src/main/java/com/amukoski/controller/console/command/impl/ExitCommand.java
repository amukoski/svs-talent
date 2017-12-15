package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(7)
@Component
public class ExitCommand implements Command {

    private String name = "Exit";

    public ExitCommand() {
    }

    public ExitCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
