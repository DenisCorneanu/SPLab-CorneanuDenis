package com.example.splabcorneanudenis.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientComponent {

    private final TransientComponent transientComponent;
    private final SingletonComponent singletonComponent;

    @Autowired   // constructor injection
    public ClientComponent(TransientComponent transientComponent,
                           SingletonComponent singletonComponent) {
        this.transientComponent = transientComponent;
        this.singletonComponent = singletonComponent;
    }

    public String operation() {
        return "ClientComponent using -> " +
                transientComponent.operation() + " | " +
                singletonComponent.operation();
    }

    @Override
    public String toString() {
        return operation();
    }
}
