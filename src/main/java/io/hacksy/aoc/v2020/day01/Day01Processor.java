package io.hacksy.aoc.v2020.day01;

import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import io.vavr.control.Option;

public class Day01Processor {
    int partOne(List<Integer> input) {
        return sub(2020, HashSet.ofAll(input)).get();
    }

    int partTwo(List<Integer> input) {
        var seen = HashSet.ofAll(input);
        return seen.toStream()
                .flatMap(i -> sub(2020 - i, seen).map(j -> i * j))
                .take(1).get();
    }

    Option<Integer> sub(int total, Set<Integer> ints) {
        return ints
                .find(i -> ints.contains(total - i))
                .map(i -> i * (total - i));
    }
}
