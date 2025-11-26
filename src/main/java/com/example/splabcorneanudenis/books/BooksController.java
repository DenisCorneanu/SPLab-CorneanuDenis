package com.example.splabcorneanudenis.books;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<BookResource>> getAll() {
        Command<List<BookResource>> cmd =
                new GetAllBooksCommand(booksService);
        return ResponseEntity.ok(cmd.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResource> getById(@PathVariable Long id) {
        Command<java.util.Optional<BookResource>> cmd =
                new GetBookByIdCommand(booksService, id);
        return cmd.execute()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookResource> create(@RequestBody BookResource book) {
        Command<BookResource> cmd =
                new CreateBookCommand(booksService, book);
        BookResource created = cmd.execute();
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResource> update(@PathVariable Long id,
                                               @RequestBody BookResource book) {
        Command<java.util.Optional<BookResource>> cmd =
                new UpdateBookCommand(booksService, id, book);
        return cmd.execute()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Command<Boolean> cmd =
                new DeleteBookCommand(booksService, id);
        boolean deleted = cmd.execute();
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
