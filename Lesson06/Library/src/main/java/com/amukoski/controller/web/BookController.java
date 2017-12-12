package com.amukoski.controller.web;

import com.amukoski.model.Book;
import com.amukoski.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @PostMapping
    public Book registerBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}
