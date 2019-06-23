package com.example.demo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

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




}
