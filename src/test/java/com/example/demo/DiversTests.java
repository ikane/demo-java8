package com.example.demo;


import com.example.demo.optionals.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DiversTests {

    @Test
    public void localVariablesTest() {
        final Integer n = 4;

        Function<Integer, Integer> modulo = (Integer a) -> a % n;

        assertThat(modulo.apply(8)).isEqualTo(0);
    }

    /**
     * Une Function prend un argument et retourne un resultat.
     *
     *  - BiFunction     ===> prend deux arguments
     *  - UnaryOperator  ===> prend un argument et retourne un resultat du meme type
     *  - BinaryOperator ===> specialisation de BiFunction dont les parametres et le resultat partagent le meme type.
     */
    @Test
    public void testFunction() {
        Function<Integer, String> toString = n -> String.valueOf(n);
        Function<String, Integer> toInteger = s -> Integer.valueOf(s);

        assertThat(toString.apply(4)).isEqualTo("4");
        assertThat(toInteger.apply("4")).isEqualTo(4);

        assertThat(toString.compose(toInteger).apply("4")).isEqualTo("4");

    }

    /**
     * Un predicate prend un argument et retourne un boolean
     *  - BiPredicate ===> prend 2 arguments et retourne un boolean
     */
    @Test
    public void testPredicate() {
        Predicate<String> isEmpty = s -> s==null || s.isEmpty();

        assertThat(isEmpty.test(null)).isTrue();

        //*******
        Predicate<String> isTrimmed = s -> s.equals(s.trim());

        assertThat(isTrimmed.test("toto ")).isFalse();
        assertThat(isTrimmed.test("test")).isTrue();

        assertThat(isEmpty.negate().and(isTrimmed).test("not empty")).isTrue();
        assertThat(isEmpty.negate().and(isTrimmed).test(" not empty")).isFalse();

        assertThat(isEmpty.or(isTrimmed).test("")).isTrue();
        assertThat(isEmpty.or(isTrimmed).test("not empty")).isTrue();
    }

    /**
     * Un Supplier ne prend pas d'arguments et produit un resultat
     */
    @Test
    public  void testSupplier() {

        Supplier<String> emptyString = () -> "";

        assertThat(emptyString.get()).isEqualTo("");
    }

    /**
     * Stream: un Streamm est une séquence d'éléments sur laquelle on peut effectuer des operations.
     *
     *  - source (tableau, collection, etc...)
     *  - zero ou plusieurs operations intermediaires (transformation du stream en une autre via filter par expe)
     *  - Operation terminale (qui produit le resultat
     */
    @Test
    public void testStream() {
        List<Individu> persons = Arrays.asList(
                new Individu("John", "Doe", 30),
                new Individu("Jane", "Doe", 20),
                new Individu("Jim", "Smith", 15)
        );

        assertThat(persons.stream().count()).isEqualTo(3l);

        //IntStream
        //assertThat(IntStream.range(0,10).sum()).isEqualTo(45);

        //Stream infini
        Random random = new Random();
        Stream.generate(()->random.nextInt())
                .limit(10)
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        //forEach
        persons.forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastName()));

        System.out.println("----------------------------------");

        //Filter
        persons.stream()
                .filter(p -> p.getLastName().startsWith("D"))
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        //Sorted
        persons.stream()
                .sorted((p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                .forEach(System.out::println);

        System.out.println("----------------------------------");
        //Map - applique une Function sur les elements - operation intermedaire
        persons.stream()
                .map(Individu::getAge)
                .sorted()
                .forEach(System.out::println);

    }




}
