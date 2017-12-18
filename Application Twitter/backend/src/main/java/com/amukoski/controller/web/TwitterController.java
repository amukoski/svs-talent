package com.amukoski.controller.web;

import com.amukoski.model.Tweet;
import com.amukoski.model.Twitter;
import com.amukoski.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)  // angular-cli
@RestController
@RequestMapping("/twitters")
public class TwitterController {

    private TwitterService twitterService;

    @Autowired
    public TwitterController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @GetMapping
    public List<Twitter> getAllTwitters() {
        return twitterService.listAllTwitters();
    }

    @GetMapping("/{id}")
    public Twitter getTwitterById(@PathVariable("id") Long id) {
        return twitterService.findTwitter(id);
    }

    @GetMapping("/email/{email}")
    public Twitter getTwitterByEmail(@PathVariable("email") String email) {
        return twitterService.findTwitter(email);
    }

    // Authenticated
    @GetMapping("/{id}/tweets")
    public List<Tweet> getTwitterTweets(@PathVariable("id") Long id) {
        return twitterService.findAllTwittersTweets(id);
    }

    // Authenticated
    @GetMapping("/email-search/{email}")
    public List<Twitter> getAllTwittersByEmailLike(@PathVariable("email") String email) {
        return twitterService.findAllTwittersWithEmailsLike(email);
    }

    // Authenticated
    @GetMapping("/followers")
    public List<Twitter> getAllFollowers() {
        return twitterService.followers();
    }

    // Authenticated
    @GetMapping("/followings")
    public List<Twitter> getAllTwitterIFollow() {
        return twitterService.followings();
    }

    @PostMapping
    public Twitter createTwitter(@RequestBody Twitter twitter) {
        return twitterService.createTwitter(twitter);
    }

    @PutMapping
    public Twitter updateTwitter(@RequestBody Twitter twitter) {
        return twitterService.updateTwitter(twitter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTwitter(@PathVariable("id") Long id) {
        return twitterService.deleteTwitter(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Authenticated
    @PostMapping("/follow/{id}")
    public ResponseEntity follow(@PathVariable("id") Long id) {
        Twitter twitter = twitterService.follow(id);
        return twitter != null ? ResponseEntity.ok(twitter) : ResponseEntity.notFound().build();
    }
}
