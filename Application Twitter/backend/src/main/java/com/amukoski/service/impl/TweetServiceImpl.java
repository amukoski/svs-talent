package com.amukoski.service.impl;

import com.amukoski.model.Tweet;
import com.amukoski.model.Twitter;
import com.amukoski.repository.TweetRepository;
import com.amukoski.repository.TwitterRepository;
import com.amukoski.security.Authenticator;
import com.amukoski.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    private TweetRepository tweetRepository;
    private TwitterRepository twitterRepository;
    private Authenticator authenticator;

    @Autowired
    public TweetServiceImpl(TweetRepository tweetRepository, TwitterRepository twitterRepository, Authenticator authenticator) {
        this.tweetRepository = tweetRepository;
        this.twitterRepository = twitterRepository;
        this.authenticator = authenticator;
    }

    @Override
    public List<Tweet> listAllTweets(Sort sort) {
        return tweetRepository.findAll(sort);
    }

    // Authenticated
    @Override
    public List<Tweet> listAllTweetsFromFollowingTwitters(Sort sort) {
        Twitter authenticatedTwitter = authenticator.getAuthenticatedTwitter();
        List<Twitter> twitters = authenticatedTwitter.getFollowing();
        twitters.add(authenticatedTwitter);

        return tweetRepository.findAllByTwitterIn(twitters, sort);
    }

    @Override
    public List<Tweet> listAllTweetsFrom(Long twitterId) {
        return tweetRepository.findAllByTwitter_Id(twitterId);
    }

    @Override
    public Tweet findTweet(Long id) {
        return tweetRepository.findOne(id);
    }

    // Authenticated
    @Override
    public Tweet createTweet(Tweet tweet) {
        Twitter authenticatedTwitter = authenticator.getAuthenticatedTwitter();
        tweet.setTwitter(authenticatedTwitter);
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {
        Tweet exist = findTweet(tweet.getId());
        if (exist == null) {
            return createTweet(tweet);
        }

        exist.setText(tweet.getText());
        exist.setTime(LocalDateTime.now());
        return tweetRepository.save(exist);
    }

    @Override
    public Boolean deleteTweet(Long id) {
        if (!twitterRepository.exists(id)) {
            return Boolean.FALSE;
        }

        tweetRepository.delete(id);
        return !tweetRepository.exists(id);
    }
}
