package com.amukoski.service.impl;

import com.amukoski.model.Twitter;
import com.amukoski.repository.TwitterRepository;
import com.amukoski.security.Authenticator;
import com.amukoski.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Twitter follow(Long toFollowId) {
        Twitter authenticatedTwitter = authenticator.getAuthenticatedTwitter();
        Long authenticatedTwitterId = authenticatedTwitter.getId();
        if (authenticatedTwitterId.equals(toFollowId)) {
            throw new IllegalArgumentException("You cannot follow you");
        }

        Twitter second = twitterRepository.findOne(toFollowId);
        if (second == null) {
            return null;
        }

        authenticatedTwitter.getFollowing().add(second);
        return twitterRepository.save(authenticatedTwitter);
    }
}
