package com.amukoski.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Twitter {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "twitter")
    private List<Tweet> tweets;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Twitter> following;

    @JsonIgnore
    @ManyToMany(mappedBy = "following", fetch = FetchType.EAGER)
    private List<Twitter> followers;

    public Twitter() {
    }

    public Twitter(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Twitter(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public List<Twitter> getFollowing() {
        return following;
    }

    public List<Twitter> getFollowers() {
        return followers;
    }

    @Override
    public String toString() {
        return "Twitter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Twitter twitter = (Twitter) o;
        return Objects.equals(id, twitter.id) &&
                Objects.equals(email, twitter.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
