package com.amukoski.service.impl;

import com.amukoski.model.Tweet;
import com.amukoski.model.Twitter;
import com.amukoski.repository.TwitterRepository;
import com.amukoski.security.Authenticator;
import com.amukoski.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TwitterServiceImpl implements TwitterService {

    private TwitterRepository twitterRepository;
    private Authenticator authenticator;

    @Autowired
    public TwitterServiceImpl(TwitterRepository twitterRepository, Authenticator authenticator) {
        this.twitterRepository = twitterRepository;
        this.authenticator = authenticator;
    }

    @Override
    public List<Twitter> listAllTwitters() {
        return (List<Twitter>) twitterRepository.findAll();
    }

    @Override
    public Twitter findTwitter(Long id) {
        return twitterRepository.findOne(id);
    }

    @Override
    public Twitter findTwitter(String email) {
        return twitterRepository.findByEmail(email);
    }

    @Override
    public Twitter createTwitter(Twitter twitter) {
        return twitterRepository.save(twitter);
    }

    @Override
    public Twitter updateTwitter(Twitter twitter) {
        Twitter exist = findTwitter(twitter.getId());
        if (exist == null) {
            return createTwitter(twitter);
        }

        exist.setEmail(twitter.getEmail());
        exist.setName(twitter.getName());
        return twitterRepository.save(exist);
    }

    @Override
    public Boolean deleteTwitter(Long id) {
        if (!twitterRepository.exists(id)) {
            return Boolean.FALSE;
        }

        twitterRepository.delete(id);
        return !twitterRepository.exists(id);
    }

    // Authenticated
    @Override
    public List<Twitter> findAllTwittersWithEmailsLike(String email) {
        Twitter authenticatedTwitter = authenticator.getAuthenticatedTwitter();
        List<Twitter> byEmailContaining = twitterRepository.findByEmailContaining(email);
        byEmailContaining.remove(authenticatedTwitter);
        return byEmailContaining;
    }

    // Authenticated
    @Override
    public Twitter follow(Long toFollowId) {
        Twitter authenticatedTwitter = authenticator.getAuthenticatedTwitter();
        Long authenticatedTwitterId = authenticatedTwitter.getId();
        if (authenticatedTwitterId.equals(toFollowId)) {
            throw new IllegalArgumentException("You cannot follow you");
        }

        Twitter first = twitterRepository.findOne(authenticatedTwitterId);
        Twitter second = twitterRepository.findOne(toFollowId);
        if (second == null || first == null) {
            return null;
        }

        if (!first.getFollowing().contains(second)) {
            first.getFollowing().add(second);
        }

        authenticator.login(twitterRepository.save(first));
        return first;
    }

    // Authenticated
    @Override
    public List<Twitter> followers() {
        Twitter authenticatedTwitter = authenticator.getAuthenticatedTwitter();
        return authenticatedTwitter.getFollowers();
    }

    // Authenticated
    @Override
    public List<Twitter> followings() {
        Twitter authenticatedTwitter = authenticator.getAuthenticatedTwitter();
        return authenticatedTwitter.getFollowing();
    }

    @Override
    public List<Tweet> findAllTwittersTweets(Long id) {
        Twitter twitter = findTwitter(id);
        return twitter.getTweets();
    }
}
