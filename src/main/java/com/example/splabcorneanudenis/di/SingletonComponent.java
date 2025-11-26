package com.example.splabcorneanudenis.di;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component   // bean singleton (default)
public class SingletonComponent {

    private final UUID id = UUID.randomUUID();

    public String operation() {
        return "SingletonComponent id=" + id;
    }

    @Override
    public String toString() {
        return operation();
    }
}
