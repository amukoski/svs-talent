package com.amukoski.frontend.view;

public interface TweetingMessagesView {
    void displayMenu();

    void displayRecentTweets();

    Integer selectFromMenu();

    void createTweetMessage();

    void deleteTweetMessage();

    void updateTweetMessage();

    void exit();
}
