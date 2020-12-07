package io.hacksy.aoc.v2020.day03;

import io.vavr.collection.List;

public class Day03Processor {
    int partOne(List<String> input) {
        return sub(input, 3, 1);
    }

    int partTwo(List<String> input) {
        return List.of(
                sub(input, 1, 1),
                sub(input, 3, 1),
                sub(input, 5, 1),
                sub(input, 7, 1),
                sub(input, 1, 2)
        ).product().intValue();
    }

    int sub(List<String> input, int right, int down) {
        return List.range(0, input.size() / down)
                .map(i -> input.get(i * down).charAt((i * right) % input.get(i * down).length()))
                .filter(c -> c == '#')
                .size();
    }
}
