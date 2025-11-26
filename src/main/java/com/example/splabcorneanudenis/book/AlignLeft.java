package com.example.splabcorneanudenis.book;

public class AlignLeft implements AlignStrategy {

    @Override
    public void render(String text) {
        System.out.println("Paragraph (LEFT): " + text);
    }
}
