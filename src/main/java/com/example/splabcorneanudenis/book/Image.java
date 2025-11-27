package com.example.splabcorneanudenis.book;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image extends BaseElement {

    private String imageName;

    public Image(String name) {
        this.imageName = name;
    }

    @Override
    public void print() {
        System.out.println("Image: " + imageName);
    }
}
