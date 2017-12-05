package com.amukoski.backend.repository.impl;

import com.amukoski.backend.model.TweetMessage;
import com.amukoski.backend.repository.TweetMessageRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTweetMessageRepository implements TweetMessageRepository {

    private Map<Long, TweetMessage> tweetMessageMap = new HashMap<>();

    @Override
    public List<TweetMessage> readAllTweetMessages() {
        return new ArrayList<>(tweetMessageMap.values());
    }

    @Override
    public TweetMessage createTweetMessage(TweetMessage tweet) {
        tweetMessageMap.put(tweet.getId(), tweet);
        return tweetMessageMap.get(tweet.getId());
    }

    @Override
    public TweetMessage readTweetMessage(Long id) {
        return tweetMessageMap.get(id);
    }

    @Override
    public TweetMessage updateTweetMessage(Long id, TweetMessage tweet) {
        return tweetMessageMap.put(id, tweet);
    }

    @Override
    public Boolean deleteTweetMessage(Long id) {
        return tweetMessageMap.remove(id) != null;
    }
}
