package com.amukoski.security;

import com.amukoski.model.Twitter;
import com.amukoski.security.exception.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class TwitterAuthentication implements Authenticator {

    private Twitter authenticatedTwitter;

    @Override
    public Boolean login(Twitter twitter) {
        authenticatedTwitter = twitter;
        return authenticatedTwitter != null;
    }

    @Override
    public Twitter logout() throws AuthenticationException {
        if (authenticatedTwitter == null) {
            throw new AuthenticationException("No Such Authenticated Twitter Exists");
        }

        Twitter twitter = new Twitter();
        twitter.setId(authenticatedTwitter.getId());
        twitter.setEmail(authenticatedTwitter.getEmail());

        authenticatedTwitter = null;
        return twitter;
    }

    @Override
    public Twitter getAuthenticatedTwitter() throws AuthenticationException {
        if (authenticatedTwitter == null) {
            throw new AuthenticationException("Not Authenticated");
        }

        return authenticatedTwitter;
    }
}
