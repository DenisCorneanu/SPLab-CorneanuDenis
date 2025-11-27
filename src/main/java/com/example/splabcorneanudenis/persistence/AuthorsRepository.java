package com.example.splabcorneanudenis.persistence;

import com.example.splabcorneanudenis.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
