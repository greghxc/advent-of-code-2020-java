package io.hacksy.aoc.v2020.day11;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day11ProcessorTest {

    @Test
    void partOne() {
        var input = List.of(
                "L.LL.LL.LL",
                "LLLLLLL.LL",
                "L.L.L..L..",
                "LLLL.LL.LL",
                "L.LL.LL.LL",
                "L.LLLLL.LL",
                "..L.L.....",
                "LLLLLLLLLL",
                "L.LLLLLL.L",
                "L.LLLLL.LL"
        );
        var processor = new Day11Processor();
        assertThat(processor.partOne(input)).isEqualTo(37);
    }

    @Test
    void partTwo() {
        var input = List.of(
                "L.LL.LL.LL",
                "LLLLLLL.LL",
                "L.L.L..L..",
                "LLLL.LL.LL",
                "L.LL.LL.LL",
                "L.LLLLL.LL",
                "..L.L.....",
                "LLLLLLLLLL",
                "L.LLLLLL.L",
                "L.LLLLL.LL"
        );
        var processor = new Day11Processor();
        assertThat(processor.partTwo(input)).isEqualTo(26);
    }
}