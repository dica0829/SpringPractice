package com.example;

import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot x = new Parrot();
        x.setName("Kiki");
        Parrot y = new Parrot();
        y.setName("Riki");
        Supplier<Parrot> parrotSupplier = () -> x;

        context.registerBean("parrot1", Parrot.class, parrotSupplier);
        
        parrotSupplier = () -> y;
        context.registerBean("parrot2", Parrot.class, parrotSupplier);
        
        Parrot p = context.getBean("parrot1", Parrot.class);
        System.out.println(p.getName());

        Parrot p2 = context.getBean("parrot2", Parrot.class);
        System.out.println(p2.getName());
    }
}