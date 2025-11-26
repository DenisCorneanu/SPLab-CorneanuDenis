package com.example.splabcorneanudenis.book;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {

    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super("Book: " + title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public void print() {
        // titlul cărții
        System.out.println(title);

        // autorii
        System.out.println("Authors:");
        for (Author a : authors) {
            a.print();
        }

        // conținutul (paragrafe, secțiuni etc.)
        for (Element e : elements) {
            e.print();
        }
    }
}
