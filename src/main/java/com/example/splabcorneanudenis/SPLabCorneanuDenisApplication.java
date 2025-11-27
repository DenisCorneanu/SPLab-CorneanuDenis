package com.example.splabcorneanudenis;

import com.example.splabcorneanudenis.di.ClientComponent;
import com.example.splabcorneanudenis.di.SingletonComponent;
import com.example.splabcorneanudenis.di.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class SPLabCorneanuDenisApplication {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(SPLabCorneanuDenisApplication.class, args);

        System.out.println("=== DI demo in main ===");

        TransientComponent t1 = context.getBean(TransientComponent.class);
        TransientComponent t2 = context.getBean(TransientComponent.class);

        SingletonComponent s1 = context.getBean(SingletonComponent.class);
        SingletonComponent s2 = context.getBean(SingletonComponent.class);

        ClientComponent client = context.getBean(ClientComponent.class);

        System.out.println("t1: " + t1.operation());
        System.out.println("t2: " + t2.operation());
        System.out.println("s1: " + s1.operation());
        System.out.println("s2: " + s2.operation());
        System.out.println("client: " + client.operation());
    }
}
