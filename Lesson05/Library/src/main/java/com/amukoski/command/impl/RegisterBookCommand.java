package com.amukoski.command.impl;

import com.amukoski.command.Command;
import com.amukoski.model.Book;
import com.amukoski.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(1) // only for menu view
@Component
public class RegisterBookCommand implements Command {

    private BookRepository bookRepository;

    @Autowired
    public RegisterBookCommand(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String commandName() {
        return "Register Book";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Book[isbn]:");
        String isbn = scanner.nextLine();
        System.out.print("Book[title]:");
        String title = scanner.nextLine();

        Book savedBook = bookRepository.save(new Book(isbn, title));
        System.out.println("Saved: " + savedBook);
    }
}
