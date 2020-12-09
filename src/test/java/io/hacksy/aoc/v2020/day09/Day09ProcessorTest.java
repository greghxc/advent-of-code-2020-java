package io.hacksy.aoc.v2020.day09;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day09ProcessorTest {

    @Test
    void partOne() {
        var input = List.of("35", "20", "15", "25", "47", "40", "62", "55", "65", "95", "102", "117",
                "150", "182", "127", "219", "299", "277", "309", "576");
        var processor = new Day09Processor(5);
        assertThat(processor.partOne(input)).isEqualTo(127);
    }

    @Test
    void partTwo() {
        var input = List.of("35", "20", "15", "25", "47", "40", "62", "55", "65", "95", "102", "117",
                "150", "182", "127", "219", "299", "277", "309", "576");
        var processor = new Day09Processor(5);
        assertThat(processor.partTwo(input)).isEqualTo(62);
    }
}