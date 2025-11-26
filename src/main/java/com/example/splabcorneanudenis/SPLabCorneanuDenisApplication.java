package com.example.splabcorneanudenis;

import com.example.splabcorneanudenis.book.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SPLabCorneanuDenisApplication {

    public static void main(String[] args) {
        // SpringApplication.run(SPLabCorneanuDenisApplication.class, args);

        Section cap1 = new Section("Capitolul 1");

        Paragraph p1 = new Paragraph("Textul primului paragraf");
        Paragraph p2 = new Paragraph("Al doilea paragraf");
        Paragraph p3 = new Paragraph("Al treilea paragraf");
        Paragraph p4 = new Paragraph("Al patrulea paragraf");

        cap1.add(p1);
        cap1.add(p2);
        cap1.add(p3);
        cap1.add(p4);

        System.out.println("=== Printing WITHOUT alignment ===");
        cap1.print();

        // setăm strategiile de aliniere
        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());
        // p4 rămâne fără strategy → se va printa default

        System.out.println("\n=== Printing WITH alignment ===");
        cap1.print();
    }
}
