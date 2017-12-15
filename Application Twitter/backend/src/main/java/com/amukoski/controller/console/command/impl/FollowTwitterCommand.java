package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.controller.console.inputreader.InputReader;
import com.amukoski.model.Twitter;
import com.amukoski.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(5)
@Component
public class FollowTwitterCommand implements Command {

    private String name = "Follow a twitter";
    private TwitterService twitterService;
    private InputReader inputReader;

    public FollowTwitterCommand() {
    }

    public FollowTwitterCommand(String name) {
        this.name = name;
    }

    @Autowired
    public FollowTwitterCommand(TwitterService twitterService, InputReader inputReader) {
        this.twitterService = twitterService;
        this.inputReader = inputReader;
    }

    @Override
    public void execute() {
        Long toFollowID = Long.valueOf(inputReader.readFromInput("Follow twitter with id:"));

        Twitter saved = twitterService.follow(toFollowID);
        if (saved != null) {
            System.out.printf("**You started following Twitter[%d]\n", toFollowID);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
