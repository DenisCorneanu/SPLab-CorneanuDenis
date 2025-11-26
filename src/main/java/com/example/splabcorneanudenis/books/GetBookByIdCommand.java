package com.example.splabcorneanudenis.books;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<BookResource>> {

    private final BooksService booksService;
    private final Long id;

    public GetBookByIdCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Optional<BookResource> execute() {
        return booksService.findById(id);
    }
}
