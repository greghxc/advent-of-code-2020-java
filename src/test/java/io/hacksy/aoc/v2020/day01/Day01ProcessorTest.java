package io.hacksy.aoc.v2020.day01;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day01ProcessorTest {
    @Test
    void partOne() {
        var processor = new Day01Processor();
        List<Integer> input = List.of(1721, 979, 366, 299, 675, 1456);
        assertThat(processor.partOne(input)).isEqualTo(514579);
    }

    @Test
    void partTwo() {
        var processor = new Day01Processor();
        List<Integer> input = List.of(1721, 979, 366, 299, 675, 1456);
        assertThat(processor.partTwo(input)).isEqualTo(241861950);    }
}