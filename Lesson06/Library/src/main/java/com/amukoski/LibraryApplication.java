package com.amukoski;

import com.amukoski.controller.console.LibraryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);

        context.getBean(LibraryController.class).run();
    }
}
