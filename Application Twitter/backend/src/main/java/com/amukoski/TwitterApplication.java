package com.amukoski;

import com.amukoski.controller.console.TwitterConsoleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TwitterApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(TwitterApplication.class, args);

        context.getBean(TwitterConsoleController.class).run();
    }
}
