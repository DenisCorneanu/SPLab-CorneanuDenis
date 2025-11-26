package com.example.splabcorneanudenis.books;

import java.util.List;

public class GetAllBooksCommand implements Command<List<BookResource>> {

    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<BookResource> execute() {
        return booksService.findAll();
    }
}
