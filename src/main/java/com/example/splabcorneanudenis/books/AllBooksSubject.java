package com.example.splabcorneanudenis.books;

import com.example.splabcorneanudenis.book.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject {

    private final List<BooksObserver> observers = new CopyOnWriteArrayList<>();

    public void attach(BooksObserver observer) {
        observers.add(observer);
    }

    public void detach(BooksObserver observer) {
        observers.remove(observer);
    }

    public void add(Book book) {
        // notifica toti observerii despre cartea nouă
        for (BooksObserver o : observers) {
            o.update(book);
        }
    }
}
