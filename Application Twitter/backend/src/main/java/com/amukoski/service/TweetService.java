package com.amukoski.service;

import com.amukoski.model.Tweet;
import com.amukoski.model.Twitter;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;

public interface TweetService {
    List<Tweet> listAllTweets(Sort sort);

    List<Tweet> listAllTweetsFrom(Long twitterId);

    List<Tweet> listAllTweetsFromFollowingTwitters(Sort sort);

    Tweet findTweet(Long id);

    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Boolean deleteTweet(Long id);
}
