package com.example.splabcorneanudenis.di;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)   // bean nou la fiecare cerere
public class TransientComponent {

    private final UUID id = UUID.randomUUID();

    public String operation() {
        return "TransientComponent id=" + id;
    }

    @Override
    public String toString() {
        return operation();
    }
}
