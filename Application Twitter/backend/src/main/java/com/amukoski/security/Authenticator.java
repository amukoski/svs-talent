package com.amukoski.security;

import com.amukoski.model.Twitter;
import com.amukoski.security.exception.AuthenticationException;

public interface Authenticator {
    Boolean login(Twitter twitter);

    Twitter logout() throws AuthenticationException;

    Twitter getAuthenticatedTwitter() throws AuthenticationException;
}
