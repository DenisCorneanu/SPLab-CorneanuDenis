package com.example.splabcorneanudenis.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books-sse")
    public SseEmitter getBooksSse() {
        SseEmitter emitter = new SseEmitter(0L); // fără timeout forțat

        SseObserver observer = new SseObserver(emitter);
        allBooksSubject.attach(observer);

        // la închidere sau timeout, detașăm observer-ul
        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> allBooksSubject.detach(observer));

        return emitter;
    }
}
