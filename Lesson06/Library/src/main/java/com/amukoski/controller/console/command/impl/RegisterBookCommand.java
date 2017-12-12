package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.controller.console.inputreader.InputReader;
import com.amukoski.model.Book;
import com.amukoski.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(1) // only for menu view
@Component
public class RegisterBookCommand implements Command {

    private BookService bookService;
    private InputReader inputReader;

    @Autowired
    public RegisterBookCommand(BookService bookService, InputReader inputReader) {
        this.bookService = bookService;
        this.inputReader = inputReader;
    }

    @Override
    public String commandName() {
        return "Register Book";
    }

    @Override
    public void execute() {
        String isbn = inputReader.readFromInput("Book[isbn]:");
        String title = inputReader.readFromInput("Book[title]:");

        Book savedBook = bookService.createBook(new Book(isbn, title));
        System.out.println("Saved: " + savedBook);
    }
}
