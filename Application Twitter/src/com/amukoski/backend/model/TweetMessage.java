package com.amukoski.backend.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class TweetMessage {

    private Long id;
    private String text;
    private LocalDateTime dateTime;
    private Account account;

    public TweetMessage() {
    }

    public TweetMessage(Long id, String text, LocalDateTime dateTime, Account account) {
        this.id = id;
        this.text = text;
        this.dateTime = dateTime;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Tweet[" + id +
                "]: \'" + text + '\'' +
                " | " + dateTime +
                " | " + account.getUsername();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TweetMessage that = (TweetMessage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(text, that.text) &&
                Objects.equals(dateTime, that.dateTime) &&
                Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, dateTime, account);
    }
}
