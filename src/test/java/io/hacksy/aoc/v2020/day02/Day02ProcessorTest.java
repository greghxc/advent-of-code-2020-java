package io.hacksy.aoc.v2020.day02;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day02ProcessorTest {

    @Test
    void partOne() {
        var processor = new Day02Processor();
        var input = List.of(
                "1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc"
        );
        var expected = "2";
        assertThat(processor.partOne(input)).isEqualTo(expected);
    }

    @Test
    void partTwo() {
        var processor = new Day02Processor();
        var input = List.of(
                "1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc"
        );
        var expected = "1";
        assertThat(processor.partTwo(input)).isEqualTo(expected);
    }

    @Test
    void test01() {
        var i = "aaa";
        System.out.println(i.length() > 1 ^ i.length() < 3);
    }
}