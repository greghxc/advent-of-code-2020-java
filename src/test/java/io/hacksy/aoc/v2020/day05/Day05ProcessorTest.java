package io.hacksy.aoc.v2020.day05;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day05ProcessorTest {

    @Test
    void partOne01() {
        var p = new Day05Processor();
        var input = List.of("FBFBBFFRLR");
        assertThat(p.partOne(input)).isEqualTo("357");
    }

    @Test
    void partOne02() {
        var p = new Day05Processor();
        var input = List.of("BFFFBBFRRR");
        assertThat(p.partOne(input)).isEqualTo("567");
    }

    @Test
    void partOne03() {
        var p = new Day05Processor();
        var input = List.of("FFFBBBFRRR");
        assertThat(p.partOne(input)).isEqualTo("119");
    }

    @Test
    void partOne04() {
        var p = new Day05Processor();
        var input = List.of("BBFFBBFRLL");
        assertThat(p.partOne(input)).isEqualTo("820");
    }
}