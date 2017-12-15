package com.amukoski.repository;

import com.amukoski.model.Tweet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component // not used // H2 & Spring Data JPA Now
public class InMemoryTweetRepository {

    private Map<Long, Tweet> tweetMap = new HashMap<>();
    private Long idGenerator = 1L;

    public List<Tweet> readAllTweets() {
        return new ArrayList<>(tweetMap.values());
    }

    public Tweet readTweet(Long id) {
        return tweetMap.get(id);
    }

    public Tweet saveTweet(Tweet tweet) {
        tweet.setId(idGenerator++);

        tweetMap.put(tweet.getId(), tweet);
        return tweetMap.get(tweet.getId());
    }

    public Tweet updateTweet(Tweet tweet) {
        tweetMap.put(tweet.getId(), tweet);
        return tweetMap.get(tweet.getId());
    }

    public Boolean deleteTweet(Long id) {
        return tweetMap.remove(id) != null;
    }
}
