package io.hacksy.aoc.v2020.day10;

import io.hacksy.aoc.v2020.day09.Day09Processor;
import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day10ProcessorTest {

    @Test
    void partOne() {
        var input = List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4);
        var processor = new Day10Processor();
        assertThat(processor.partOne(input)).isEqualTo(35);
    }

    @Test
    void partTwo() {
        var input = List.of(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4);
        var processor = new Day10Processor();
        assertThat(processor.partTwo(input)).isEqualTo(8L);
    }

    @Test
    void PartTwo() {
        var input = List.of(28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3);
        var processor = new Day10Processor();
        assertThat(processor.partTwo(input)).isEqualTo(19208L);
    }
}