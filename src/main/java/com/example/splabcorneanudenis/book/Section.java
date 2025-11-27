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
public class Section extends BaseElement {

    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BaseElement> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public void add(Element element) {
        elements.add((BaseElement) element);
    }

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (Element e : elements) {
            e.print();
        }
    }
}
