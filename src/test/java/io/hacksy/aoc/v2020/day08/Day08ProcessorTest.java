package io.hacksy.aoc.v2020.day08;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day08ProcessorTest {

    @Test
    void partOne() {
        var processor = new Day08Processor();
        List<String> input = List.of(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
        );
        assertThat(processor.partOne(input)).isEqualTo(5);
    }

    @Test
    void partTwo() {
        var processor = new Day08Processor();
        List<String> input = List.of(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
        );
        assertThat(processor.partTwo(input)).isEqualTo(8);
    }
}