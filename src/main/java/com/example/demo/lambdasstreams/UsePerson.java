package com.example.demo.lambdasstreams;

import com.example.demo.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsePerson {
    private List<String> names =
            Arrays.asList("Joffrey Baratheon",
                    "Daenerys Targaryen",
                    "Jon Snow",
                    "Arya Stark",
                    "Tyrion Lannister",
                    "Margaery Tyrell");

    public List<Person> createPersonList() {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public Person[] createPersonArray() {
        return names.stream()
                .map(Person::new)
                .toArray(Person[]::new)
                ;
    }
}
