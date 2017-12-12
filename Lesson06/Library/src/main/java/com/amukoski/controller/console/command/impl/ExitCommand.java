package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(6) // only for menu view
@Component
public class ExitCommand implements Command {

    @Override
    public String commandName() {
        return "Exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}