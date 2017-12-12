package com.amukoski.controller.console.command;

public interface Command {

    String commandName();

    void execute();
}