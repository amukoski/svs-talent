package com.amukoski.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String text;

    private LocalDateTime time = LocalDateTime.now();

    @ManyToOne
    private Twitter twitter;

    public Tweet() {
    }

    public Tweet(String text) {
        this.text = text;
    }

    public Tweet(String text, Twitter twitter) {
        this.text = text;
        this.twitter = twitter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Twitter getTwitter() {
        return twitter;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", twitter=" + twitter.getEmail() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return Objects.equals(id, tweet.id) &&
                Objects.equals(text, tweet.text) &&
                Objects.equals(time, tweet.time) &&
                Objects.equals(twitter, tweet.twitter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, time, twitter);
    }
}
