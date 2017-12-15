package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.model.Twitter;
import com.amukoski.security.Authenticator;
import com.amukoski.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(3)
@Component
public class ListRecentTweetsCommand implements Command {

    private String name = "List recent tweets";
    private TweetService tweetService;
    private Authenticator authenticator;

    public ListRecentTweetsCommand() {
    }

    public ListRecentTweetsCommand(String name) {
        this.name = name;
    }

    @Autowired
    public ListRecentTweetsCommand(TweetService tweetService, Authenticator authenticator) {
        this.tweetService = tweetService;
        this.authenticator = authenticator;
    }

    @Override
    public void execute() {
        System.out.println("-Tweets----------------------");
        tweetService.listAllTweetsFromFollowingTwitters(new Sort(Sort.Direction.DESC, "time"))
                .forEach(System.out::println);
        System.out.println("-----------------------------");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
