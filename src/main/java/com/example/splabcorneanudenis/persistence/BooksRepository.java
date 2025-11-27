package com.example.splabcorneanudenis.persistence;

import com.example.splabcorneanudenis.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
