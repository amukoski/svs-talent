package com.amukoski.service;

import com.amukoski.model.Twitter;

import java.util.List;

public interface TwitterService {
    List<Twitter> listAllTwitters();

    Twitter findTwitter(Long id);

    Twitter findTwitter(String email);

    Twitter createTwitter(Twitter twitter);

    Twitter updateTwitter(Twitter twitter);

    Boolean deleteTwitter(Long id);

    Twitter follow(Long toFollow);
}
