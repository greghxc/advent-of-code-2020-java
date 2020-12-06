package io.hacksy.aoc.v2020.day06;

import io.vavr.Value;
import io.vavr.collection.CharSeq;
import io.vavr.collection.Set;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Day06Processor {
    int partOne(String input) {
        return splitToSetAndReduceUsing(Set::union).apply(input);
    }

    int partTwo(String input) {
        return splitToSetAndReduceUsing(Set::intersect).apply(input);
    }

    private Function<String, Integer> splitToSetAndReduceUsing(BinaryOperator<Set<Character>> reduceFunc) {
        return input -> CharSeq.of(input).split("\\n\\n")
                .map(group -> group.split("\\n").map(Value::toSet))
                .map(groupSets -> groupSets.reduce(reduceFunc).size())
                .sum().intValue();
    }
}
