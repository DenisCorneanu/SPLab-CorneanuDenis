package com.example.splabcorneanudenis.books;

import com.example.splabcorneanudenis.book.Book;
import com.example.splabcorneanudenis.persistence.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository repo;

    public BooksService(BooksRepository repo) {
        this.repo = repo;
    }

    public List<Book> findAll() {
        return repo.findAll();
    }

    public Optional<Book> findById(Long id) {
        return repo.findById(id);
    }

    public Book create(Book b) {
        return repo.save(b);
    }

    public Optional<Book> update(Long id, Book data) {
        // NU mai setăm id-ul manual, îl are deja entitatea din DB
        return repo.findById(id).map(existing -> {
            existing.setTitle(data.getTitle());
            existing.setAuthors(data.getAuthors());
            // dacă vrei, poți copia și alte câmpuri:
            // existing.setElements(data.getElements());
            return repo.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
