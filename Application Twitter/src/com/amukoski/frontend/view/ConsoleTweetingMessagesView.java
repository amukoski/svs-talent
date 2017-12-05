package com.amukoski.frontend.view;

import com.amukoski.backend.controller.TweetMessageController;

import java.util.List;
import java.util.Scanner;

public class ConsoleTweetingMessagesView extends Thread implements TweetingMessagesView {

    private final Scanner scanner = new Scanner(System.in);

    private TweetMessageController tweetMessageController;
    private volatile boolean running = true;

    public ConsoleTweetingMessagesView(TweetMessageController tweetMessageController) {
        this.tweetMessageController = tweetMessageController;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n\t1)List Recent Tweets\n" +
                "\t2)Tweet message\n" +
                "\t3)Delete Tweet\n" +
                "\t4)Update Tweet\n" +
                "\t5)Exit\n");
    }

    @Override
    public void displayRecentTweets() {
        List<String> tweets = tweetMessageController.listAllTweetMessagesOrderByDate();
        String tweetMessages = String.join("\n", tweets);
        if (tweetMessages.equals("")) {
            System.out.println("No tweets yet");
        } else {
            System.out.println(tweetMessages);
        }
    }

    @Override
    public Integer selectFromMenu() {
        System.out.print("Selection:");
        return scanner.nextInt();
    }

    @Override
    public void createTweetMessage() {
        System.out.print("Message:");
        scanner.nextLine();
        String message = scanner.nextLine();
        System.out.println("##" + tweetMessageController.createTweetMessage(message));
    }

    @Override
    public void deleteTweetMessage() {
        System.out.print("Insert tweet message id:");
        long id = scanner.nextLong();
        Boolean deleted = tweetMessageController.deleteTweetMessage(id);
        if (deleted) {
            System.out.println("##Tweet successfully deleted");
        } else {
            System.out.println("##Tweet cannot be deleted or not exists");
        }
    }

    @Override
    public void updateTweetMessage() {
        System.out.print("Insert tweet message id:");
        long id = scanner.nextLong();
        System.out.print("New Message:");
        scanner.nextLine();
        String newMessage = scanner.nextLine();

        System.out.println("##" + tweetMessageController.updateTweetMessage(id, newMessage));
    }

    @Override
    public void exit() {
        this.running = false;
    }

    @Override
    public void run() {
        while (running) {
            displayMenu();
            Integer choice = selectFromMenu();

            switch (choice) {
                case 1:
                    displayRecentTweets();
                    break;
                case 2:
                    createTweetMessage();
                    break;
                case 3:
                    deleteTweetMessage();
                    break;
                case 4:
                    updateTweetMessage();
                    break;
                case 5:
                    exit();
                    break;
            }
        }
    }
}
