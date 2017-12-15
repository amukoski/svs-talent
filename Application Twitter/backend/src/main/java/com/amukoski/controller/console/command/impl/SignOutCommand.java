package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.model.Twitter;
import com.amukoski.security.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(6)
@Component
public class SignOutCommand implements Command {

    private String name = "Sign Out";
    private Authenticator authenticator;

    public SignOutCommand() {
    }

    public SignOutCommand(String name) {
        this.name = name;
    }

    @Autowired
    public SignOutCommand(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public void execute() {
        Twitter deauthenticated = authenticator.logout();
        System.out.println("**" + deauthenticated + " signed out.");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
