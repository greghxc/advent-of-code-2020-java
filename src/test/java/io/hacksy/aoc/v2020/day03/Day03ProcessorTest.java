package io.hacksy.aoc.v2020.day03;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day03ProcessorTest {

    @Test
    void partOne() {
        var processor = new Day03Processor();
        List<String> input = List.of(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#"
        );
        assertThat(processor.partOne(input)).isEqualTo("7");
    }

    @Test
    void partTwo() {
        var processor = new Day03Processor();
        List<String> input = List.of(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#"
        );
        assertThat(processor.partTwo(input)).isEqualTo("336");
    }
}