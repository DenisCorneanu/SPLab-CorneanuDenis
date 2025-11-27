package com.example.splabcorneanudenis.books;

import com.example.splabcorneanudenis.book.Book;

import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {

    private final BooksService booksService;
    private final Long id;
    private final Book book;

    public UpdateBookCommand(BooksService booksService, Long id, Book book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.update(id, book);
    }
}
