package com.amukoski.command.impl;

import com.amukoski.command.Command;
import com.amukoski.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3) // only for menu view
@Component
public class ListBooksCommand implements Command {

    private BookRepository bookRepository;

    @Autowired
    public ListBooksCommand(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public String commandName() {
        return "List Books";
    }

    @Override
    public void execute() {
        System.out.println("-Books-----------------------");
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("-----------------------------");
    }

}
