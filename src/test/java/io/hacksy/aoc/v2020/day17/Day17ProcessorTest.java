package io.hacksy.aoc.v2020.day17;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day17ProcessorTest {

    @Test
    void partOne() {
        var input = List.of(".#.","..#","###");
        var processor = new Day17Processor();
        assertThat(processor.partOne(input)).isEqualTo(112);
    }

    @Test
    void partTwo() {
        var input = List.of(".#.","..#","###");
        var processor = new Day17Processor();
        assertThat(processor.partTwo(input)).isEqualTo(848);
    }

}