package com.example.splabcorneanudenis.book;

public class AlignRight implements AlignStrategy {

    private static final int LINE_WIDTH = 40;

    @Override
    public void render(String text) {
        int spaces = Math.max(0, LINE_WIDTH - text.length());
        String padding = " ".repeat(spaces);
        System.out.println("Paragraph (RIGHT): " + padding + text);
    }
}
