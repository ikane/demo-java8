package com.example.demo.lambdasstreams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SortingDemoTest {

    private SortingDemo sortingDemo = new SortingDemo();

    @Test
    void lengthSortWithLambda() {
        List<String> result = sortingDemo.lengthSortWithLambda();
        System.out.println(result);

        assertThat(result).isNotEmpty();
    }

    @Test
    void lengthSortComparator() {
        List<String> result = sortingDemo.lengthSortComparator();
        System.out.println(result);

        assertThat(result).isNotEmpty();
    }

    @Test
    void lengthSortThenAlphaSort() {
        List<String> result = sortingDemo.lengthSortThenAlphaSort();
        System.out.println(result);

        assertThat(result).isNotEmpty();
    }

    @Test
    void alphaSortUsingSorted() {
        List<String> result = sortingDemo.alphaSortUsingSorted();
        System.out.println(result);

        assertThat(result).isNotEmpty();
    }

    @Test
    void lengthSortUsingSorted() {
        List<String> result = sortingDemo.lengthSortUsingSorted();
        System.out.println(result);

        assertThat(result).isNotEmpty();
    }

    @Test
    void lengthSortThenAlphaSortUsingSorted() {
        List<String> result = sortingDemo.lengthSortThenAlphaSortUsingSorted();
        System.out.println(result);

        assertThat(result).isNotEmpty();
    }
}