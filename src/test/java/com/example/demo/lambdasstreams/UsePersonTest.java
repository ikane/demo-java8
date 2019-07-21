package com.example.demo.lambdasstreams;

import com.example.demo.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class UsePersonTest {

    UsePerson usePerson = new UsePerson();

    @Test
    void createPersonList() {
        List<Person> people = usePerson.createPersonList();

        assertThat(people).isNotEmpty();
    }

    @Test
    void createPersonArray() {
        Person[] people = usePerson.createPersonArray();

        assertThat(people).isNotEmpty();
    }
}