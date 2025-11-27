package com.example.splabcorneanudenis.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("  " + name);
    }
}
