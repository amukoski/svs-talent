package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.controller.console.inputreader.InputReader;
import com.amukoski.model.Tweet;
import com.amukoski.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4)
@Component
public class TweetMessageCommand implements Command {

    private String name = "Tweet a message";
    private TweetService tweetService;
    private InputReader inputReader;

    public TweetMessageCommand() {
    }

    public TweetMessageCommand(String name) {
        this.name = name;
    }

    @Autowired
    public TweetMessageCommand(TweetService tweetService, InputReader inputReader) {
        this.tweetService = tweetService;
        this.inputReader = inputReader;
    }

    @Override
    public void execute() {
        String message = inputReader.readFromInput("Tweet[message]:");

        Tweet savedTweet = tweetService.createTweet(new Tweet(message));
        System.out.println("**Saved: " + savedTweet);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
