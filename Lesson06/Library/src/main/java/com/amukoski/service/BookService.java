package com.amukoski.service;

import com.amukoski.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();

    Book createBook(Book book);

    Book updateBook(Book book);

    Boolean deleteBook(Long id);
}
