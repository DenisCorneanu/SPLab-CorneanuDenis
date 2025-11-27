package com.example.splabcorneanudenis.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class BaseElement implements Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseElement() { }

    public Long getId() {
        return id;
    }
}
