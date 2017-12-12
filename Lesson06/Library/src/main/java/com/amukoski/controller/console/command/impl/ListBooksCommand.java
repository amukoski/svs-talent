package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3) // only for menu view
@Component
public class ListBooksCommand implements Command {

    private BookService bookService;

    @Autowired
    public ListBooksCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public String commandName() {
        return "List Books";
    }

    @Override
    public void execute() {
        System.out.println("-Books-----------------------");
        bookService.listBooks().forEach(System.out::println);
        System.out.println("-----------------------------");
    }

}
