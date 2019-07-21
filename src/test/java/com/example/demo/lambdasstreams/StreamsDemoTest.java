package com.example.demo.lambdasstreams;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StreamsDemoTest {

    StreamsDemo streamsDemo = new StreamsDemo();

    @Test
    void joinStream() {
        assertThat(streamsDemo.joinStream()).isEqualTo("this is a list of strings");
    }

    @Test
    void joinUpperCase() {
        assertThat(streamsDemo.joinUpperCase()).contains("THIS IS A");
    }

    @Test
    void getTotalLength() {
        assertThat(streamsDemo.getTotalLength()).isEqualTo(20);
    }

    @Test
    void sumFirstNBigDecimals() {
        assertThat(streamsDemo.sumFirstNBigDecimals(5)).isEqualTo(Double.valueOf(15));
    }

    @Test
    void sumFirstNBigDecimals2() {
        assertThat(streamsDemo.sumFirstNBigDecimals2(5)).isEqualTo(Double.valueOf(15));
    }

    @Test
    void sumRandom1() {
        double result = streamsDemo.sumRandom1(5);
        assertThat(result).isGreaterThan(1);
        assertThat(result).isCloseTo(1+2+3+4+5, Percentage.withPercentage(99));
    }

    @Test
    void sumRandom2() {
        double result = streamsDemo.sumRandom2(5);
        assertThat(result).isGreaterThan(1);
    }

    @Test
    void sumRandom3() {
        double result = streamsDemo.sumRandom3(5);
        assertThat(result).isGreaterThan(1);
    }

    @Test
    void sumRandom4() {
        double result = streamsDemo.sumRandom4(5);
        assertThat(result).isGreaterThan(1);
    }
}