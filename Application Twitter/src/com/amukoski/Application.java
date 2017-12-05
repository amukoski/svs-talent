package com.amukoski;

import com.amukoski.backend.controller.TweetMessageController;
import com.amukoski.backend.repository.TweetMessageRepository;
import com.amukoski.backend.repository.impl.InMemoryTweetMessageRepository;
import com.amukoski.backend.service.TweetMessageService;
import com.amukoski.backend.service.impl.TweetMessageServiceImpl;
import com.amukoski.frontend.view.ConsoleTweetingMessagesView;

public class Application {
    public static void main(String[] args) {
        // Dependency Injection
        TweetMessageRepository repository = new InMemoryTweetMessageRepository();
        TweetMessageService service = new TweetMessageServiceImpl(repository);
        TweetMessageController controller = new TweetMessageController(service);

        new ConsoleTweetingMessagesView(controller).start();
    }
}
