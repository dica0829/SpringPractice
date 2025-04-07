package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private final Parrot parrot;
    private String name = "Ella";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }
    public String getParrot() {
        return this.parrot.getName();
    }

    // final이기 때문에 setters는 필요 없음.
}
