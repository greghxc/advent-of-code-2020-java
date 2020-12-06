package io.hacksy.aoc.v2020.day06;

import io.vavr.Value;
import io.vavr.collection.CharSeq;
import io.vavr.collection.Set;

import java.util.function.BinaryOperator;

public class Day06Processor {
    int partOne(String input) {
        return splitToSetAndReduce(input, Set::union);
    }

    int partTwo(String input) {
        return splitToSetAndReduce(input, Set::intersect);
    }

    private int splitToSetAndReduce(String input, BinaryOperator<Set<Character>> reduceFunc) {
        return CharSeq.of(input).split("\\n\\n")
                .map(group -> group.split("\\n").map(Value::toSet))
                .map(groupSets -> groupSets.reduce(reduceFunc).size())
                .sum().intValue();
    }
}
