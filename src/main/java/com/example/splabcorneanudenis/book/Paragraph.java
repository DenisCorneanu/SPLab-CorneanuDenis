package com.example.splabcorneanudenis.book;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy;   // 🔹 nou

    public Paragraph(String text) {
        this.text = text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy == null) {
            System.out.println("Paragraph: " + text);
        } else {
            alignStrategy.render(text);
        }
    }
}
