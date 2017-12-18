package com.amukoski.controller.web;

import com.amukoski.model.Tweet;
import com.amukoski.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)  // angular-cli
@RestController
@RequestMapping("/tweets")
public class TweetController {

    private TweetService tweetService;

    @Autowired
    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<Tweet> getAllTweets(Sort sort) {
        return tweetService.listAllTweets(sort);
    }

    @GetMapping("/{id}")
    public Tweet getTweetById(@PathVariable("id") Long id) {
        return tweetService.findTweet(id);
    }

    @GetMapping("/twitters/{id}")
    public List<Tweet> getAllTweetsFromTwitterWithId(@PathVariable("id") Long id) {
        return tweetService.listAllTweetsFrom(id);
    }

    // Authenticated
    @GetMapping("/twitters/following")
    public List<Tweet> getAllTweetsFromFollowingTwitters(Sort sort) {
        return tweetService.listAllTweetsFromFollowingTwitters(sort);
    }

    // Authenticated
    @PostMapping
    public Tweet createTweet(@RequestBody Tweet tweet) {
        return tweetService.createTweet(tweet);
    }

    @PutMapping
    public Tweet updateTweet(@RequestBody Tweet tweet) {
        return tweetService.updateTweet(tweet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTweet(@PathVariable("id") Long id) {
        return tweetService.deleteTweet(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
