package com.example.splabcorneanudenis.books;

import com.example.splabcorneanudenis.book.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class SseObserver implements BooksObserver {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;

        // curățare când clientul se închide / expiră
        this.emitter.onTimeout(() -> this.emitter.complete());
        this.emitter.onCompletion(() -> { /* no-op */ });
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
    }
}
