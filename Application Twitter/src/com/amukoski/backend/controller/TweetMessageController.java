package com.amukoski.backend.controller;

import com.amukoski.backend.service.TweetMessageService;

import java.util.List;

public class TweetMessageController {

    private TweetMessageService tweetMessageService;

    public TweetMessageController(TweetMessageService tweetMessageService) {
        this.tweetMessageService = tweetMessageService;
    }

    public List<String> listAllTweetMessages() {
        return tweetMessageService.getAllTweetMessages();
    }

    public List<String> listAllTweetMessagesOrderByDate() {
        return tweetMessageService.getAllTweetMessagesOrderByDate();
    }

    public String createTweetMessage(String message) {
        return tweetMessageService.addTweetMessage(message);
    }

    public String updateTweetMessage(Long id, String message) {
        return tweetMessageService.updateTweetMessage(id, message);
    }

    public Boolean deleteTweetMessage(Long id) {
        return tweetMessageService.deleteTweetMessage(id);
    }

}
