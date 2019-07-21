package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @Builder @AllArgsConstructor
public class Person {
    private Integer id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
