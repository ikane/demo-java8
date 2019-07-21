package com.example.demo.lambdasstreams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;

public class ProcessDictionary {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("c:/", "tmp", "words.txt");

        Files.lines(path)
                .filter(s -> s.length() > 10)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(10)
                .forEach(w -> System.out.printf("%s (%d)%n", w, w.length()));

        //System.out.println(path.getFileName());

        Optional<String> max = Files.lines(path)
                .filter(s -> s.length() > 10)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .findFirst();

        System.out.println(max.orElse("nothing"));
    }
}
