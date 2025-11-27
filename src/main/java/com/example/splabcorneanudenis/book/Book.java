package com.example.splabcorneanudenis.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book extends Section {

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super("Book: " + title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public void print() {
        System.out.println(getTitle());

        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }

        for (Element e : getElements()) {
            e.print();
        }
    }
}
