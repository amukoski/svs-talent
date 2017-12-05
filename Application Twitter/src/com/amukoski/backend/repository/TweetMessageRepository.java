package com.amukoski.backend.repository;

import com.amukoski.backend.model.TweetMessage;

import java.util.List;

public interface TweetMessageRepository {

    List<TweetMessage> readAllTweetMessages();

    TweetMessage createTweetMessage(TweetMessage tweet);

    TweetMessage readTweetMessage(Long id);

    TweetMessage updateTweetMessage(Long id, TweetMessage tweet);

    Boolean deleteTweetMessage(Long id);
}
