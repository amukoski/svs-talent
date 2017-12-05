package com.amukoski.backend.service.impl;

import com.amukoski.backend.model.Account;
import com.amukoski.backend.model.TweetMessage;
import com.amukoski.backend.repository.TweetMessageRepository;
import com.amukoski.backend.service.TweetMessageService;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TweetMessageServiceImpl implements TweetMessageService {

    private static Long idGenerator = 1L;
    private TweetMessageRepository tweetMessageRepository;

    public TweetMessageServiceImpl(TweetMessageRepository tweetMessageRepository) {
        this.tweetMessageRepository = tweetMessageRepository;
    }

    @Override
    public List<String> getAllTweetMessages() {
        List<TweetMessage> tweetMessages = tweetMessageRepository.readAllTweetMessages();

        return tweetMessages.stream()
                .map(TweetMessage::toString)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTweetMessagesOrderByDate() {
        List<TweetMessage> allTweetMessages = tweetMessageRepository.readAllTweetMessages();
        allTweetMessages.sort(Comparator.comparing(TweetMessage::getDateTime).reversed());

        return allTweetMessages.stream()
                .map(TweetMessage::toString)
                .collect(Collectors.toList());
    }

    @Override
    public String getTweetMessageById(Long id) {
        Optional<TweetMessage> tweetMessage = Optional.ofNullable(tweetMessageRepository.readTweetMessage(id));
        return tweetMessage.map(TweetMessage::toString).orElse("");
    }

    @Override
    public String addTweetMessage(String tweet) {
        // Account account = getAuthenticatedUser
        TweetMessage tweetMessage =
                new TweetMessage(idGenerator++, tweet, LocalDateTime.now(), new Account(1L, "Anonymous", "password"));

        Optional<TweetMessage> optional = Optional.ofNullable(tweetMessageRepository.createTweetMessage(tweetMessage));
        return optional.map(TweetMessage::toString).orElse("");
    }

    @Override
    public String updateTweetMessage(Long id, String tweet) {
        Optional<TweetMessage> tweetMessage = Optional.ofNullable(tweetMessageRepository.readTweetMessage(id));
        if (!tweetMessage.isPresent()) {
            return addTweetMessage(tweet);
        }

        tweetMessage.get().setDateTime(LocalDateTime.now());
        tweetMessage.get().setText(tweet);
        tweetMessage = Optional.ofNullable(tweetMessageRepository.updateTweetMessage(id, tweetMessage.get()));
        return tweetMessage.map(TweetMessage::toString).orElse("");
    }

    @Override
    public Boolean deleteTweetMessage(Long id) {
        return tweetMessageRepository.deleteTweetMessage(id);
    }
}
