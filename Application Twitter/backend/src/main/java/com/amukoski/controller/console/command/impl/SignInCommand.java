package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.controller.console.inputreader.InputReader;
import com.amukoski.security.Authenticator;
import com.amukoski.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class SignInCommand implements Command {

    private String name = "Sign In";
    private InputReader inputReader;
    private Authenticator authenticator;
    private TwitterService twitterService;

    public SignInCommand() {
    }

    public SignInCommand(String name) {
        this.name = name;
    }

    @Autowired
    public SignInCommand(InputReader inputReader, Authenticator authenticator, TwitterService twitterService) {
        this.inputReader = inputReader;
        this.authenticator = authenticator;
        this.twitterService = twitterService;
    }

    @Override
    public void execute() {
        String email = inputReader.readFromInput("Enter your email:");

        if (authenticator.login(twitterService.findTwitter(email))) {
            System.out.println("**Twitter '" + email + "' is now signed in.");
        } else {
            System.out.println("**Twitter with email '" + email + "' does not exist.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
