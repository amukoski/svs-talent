package com.amukoski.service.impl;

import com.amukoski.model.Book;
import com.amukoski.repository.BookRepository;
import com.amukoski.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return bookRepository.exists(id);
    }
}
