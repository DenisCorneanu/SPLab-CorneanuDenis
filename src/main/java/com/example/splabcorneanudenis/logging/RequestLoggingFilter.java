package com.example.splabcorneanudenis.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        long start = System.currentTimeMillis();
        System.out.println("[FILTER] Incoming " + request.getMethod() +
                " " + request.getRequestURI());

        // trimite cererea mai departe în lanț (Controller/alte filtre)
        filterChain.doFilter(request, response);

        long duration = System.currentTimeMillis() - start;
        System.out.println("[FILTER] Completed " + request.getMethod() +
                " " + request.getRequestURI() +
                " with status " + response.getStatus() +
                " in " + duration + " ms");
    }
}
