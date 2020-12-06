package io.hacksy.aoc.v2020.day06;

import io.vavr.Tuple;
import io.vavr.collection.List;

import java.util.Arrays;

public class Day06Processor {
    int partOne(String input) {
        return List.ofAll(Arrays.asList(input.split("\\n\\n")))
                .map(a -> List.ofAll(a.toCharArray()).filter(c -> c != '\n').toSet().size())
                .sum().intValue();
    }

    int partTwo(String input) {
        return List.ofAll(Arrays.asList(input.split("\\n\\n")))
                .map(s -> List.ofAll(s.toCharArray()).groupBy(c -> c).toMap(t -> Tuple.of(t._1, t._2.size())))
                .map(m -> m.values().filter(v -> v == m.getOrElse('\n', 0) + 1).size())
                .sum().intValue();
    }
}
