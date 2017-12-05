package com.amukoski.backend.service;

import java.util.List;

public interface TweetMessageService {

    List<String> getAllTweetMessages();

    List<String> getAllTweetMessagesOrderByDate();

    String getTweetMessageById(Long id);

    String addTweetMessage(String message);

    String updateTweetMessage(Long id, String message);

    Boolean deleteTweetMessage(Long id);
}
