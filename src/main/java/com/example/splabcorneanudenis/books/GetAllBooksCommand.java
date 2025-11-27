package com.example.splabcorneanudenis.books;

import com.example.splabcorneanudenis.book.Book;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {

    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        return booksService.findAll();
    }
}
