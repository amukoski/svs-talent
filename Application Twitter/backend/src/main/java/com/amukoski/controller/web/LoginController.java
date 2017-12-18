package com.amukoski.controller.web;

import com.amukoski.model.Twitter;
import com.amukoski.security.Authenticator;
import com.amukoski.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)  // angular-cli
@RestController
public class LoginController {

    private Authenticator authenticator;
    private TwitterService twitterService;

    @Autowired
    public LoginController(Authenticator authenticator, TwitterService twitterService) {
        this.authenticator = authenticator;
        this.twitterService = twitterService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody Twitter twitter) {
        Twitter created = twitterService.createTwitter(twitter);
        return created != null ? ResponseEntity.ok(twitter) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity signIn(@RequestBody Twitter twitter) {
        String email = twitter.getEmail();
        twitter = twitterService.findTwitter(email);
        return authenticator.login(twitter) ? ResponseEntity.ok(twitter)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/sign-out")
    public ResponseEntity signOut() {
        return authenticator.logout() != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
