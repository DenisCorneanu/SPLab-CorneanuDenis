package com.example.splabcorneanudenis.books;

import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<BookResource>> {

    private final BooksService booksService;
    private final Long id;
    private final BookResource book;

    public UpdateBookCommand(BooksService booksService, Long id, BookResource book) {
        this.booksService = booksService;
        this.id = id;
        this.book = book;
    }

    @Override
    public Optional<BookResource> execute() {
        return booksService.update(id, book);
    }
}
