package com.example.splabcorneanudenis.book;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paragraph extends BaseElement {

    private String text;

    @Transient
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        if (alignStrategy == null)
            System.out.println("Paragraph: " + text);
        else
            alignStrategy.render(text);
    }
}
