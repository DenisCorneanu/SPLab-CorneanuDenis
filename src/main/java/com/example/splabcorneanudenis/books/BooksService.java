package com.example.splabcorneanudenis.books;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BooksService {

    private final Map<Long, BookResource> books = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public BooksService() {
        // date de test
        create(new BookResource(null, "Noapte buna, copii!", "Radu Pavel Gheo"));
        create(new BookResource(null, "Baltagul", "Mihail Sadoveanu"));
    }

    public List<BookResource> findAll() {
        return new ArrayList<>(books.values());
    }

    public Optional<BookResource> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public BookResource create(BookResource book) {
        long id = idGenerator.incrementAndGet();
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public Optional<BookResource> update(Long id, BookResource book) {
        if (!books.containsKey(id)) {
            return Optional.empty();
        }
        book.setId(id);
        books.put(id, book);
        return Optional.of(book);
    }

    public boolean delete(Long id) {
        return books.remove(id) != null;
    }
}
