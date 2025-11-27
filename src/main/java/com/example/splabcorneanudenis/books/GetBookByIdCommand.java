package com.example.splabcorneanudenis.books;

import com.example.splabcorneanudenis.book.Book;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {

    private final BooksService booksService;
    private final Long id;

    public GetBookByIdCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Optional<Book> execute() {
        return booksService.findById(id);
    }
}
