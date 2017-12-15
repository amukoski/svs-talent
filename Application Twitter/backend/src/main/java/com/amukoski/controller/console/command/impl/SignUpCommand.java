package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.controller.console.inputreader.InputReader;
import com.amukoski.model.Twitter;
import com.amukoski.security.Authenticator;
import com.amukoski.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class SignUpCommand implements Command {

    private String name = "Sign Up";
    private InputReader inputReader;
    private TwitterService twitterService;
    private Authenticator authenticator;

    public SignUpCommand() {
    }

    public SignUpCommand(String name) {
        this.name = name;
    }

    @Autowired
    public SignUpCommand(InputReader inputReader, TwitterService twitterService, Authenticator authenticator) {
        this.inputReader = inputReader;
        this.twitterService = twitterService;
        this.authenticator = authenticator;
    }

    @Override
    public void execute() {
        String email = inputReader.readFromInput("Twitter[email]:");

        Twitter twitter = twitterService.createTwitter(new Twitter(email));
        System.out.println("**" + twitter + " successfully created.");

        if (authenticator.login(twitterService.findTwitter(email))) {
            System.out.println("**Twitter '" + email + "' is now signed in.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
