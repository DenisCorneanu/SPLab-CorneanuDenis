package com.example.splabcorneanudenis.books;

public class CreateBookCommand implements Command<BookResource> {

    private final BooksService booksService;
    private final BookResource book;

    public CreateBookCommand(BooksService booksService, BookResource book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public BookResource execute() {
        return booksService.create(book);
    }
}
