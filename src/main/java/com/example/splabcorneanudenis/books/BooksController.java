package com.example.splabcorneanudenis.books;

import com.example.splabcorneanudenis.book.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        Command<List<Book>> cmd = new GetAllBooksCommand(booksService);
        return ResponseEntity.ok(cmd.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Command<Optional<Book>> cmd = new GetBookByIdCommand(booksService, id);
        return cmd.execute()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Command<Book> cmd = new CreateBookCommand(booksService, book);
        Book created = cmd.execute();
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id,
                                       @RequestBody Book book) {
        Command<Optional<Book>> cmd = new UpdateBookCommand(booksService, id, book);
        return cmd.execute()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Command<Boolean> cmd = new DeleteBookCommand(booksService, id);
        boolean deleted = cmd.execute();
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
