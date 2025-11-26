package com.example.splabcorneanudenis.books;

public class DeleteBookCommand implements Command<Boolean> {

    private final BooksService booksService;
    private final Long id;

    public DeleteBookCommand(BooksService booksService, Long id) {
        this.booksService = booksService;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        return booksService.delete(id);
    }
}
