package io.hacksy.aoc.v2020.day05;

import io.vavr.collection.*;

import java.util.stream.Collectors;

import static io.vavr.API.*;

public class Day05Processor {
    private static final Set<Character> onBits = HashSet.of('B', 'R');

    String partOne(List<String> input) {
        return Integer.toString(input.map(this::processPassBin).max().get());
    }

    String partTwo(List<String> input) {
         PartTwoAggregate p = input
                .map(this::processPassBin)
                .foldLeft(
                        new PartTwoAggregate(Integer.MAX_VALUE, Integer.MIN_VALUE, 0),
                        (agg, i) -> new PartTwoAggregate(
                                    Math.min(i, agg.min()),
                                    Math.max(i, agg.max()),
                                    agg.sum() + i
                        )
                );
        return Integer.toString((int) (((p.max() + p.min()) / 2.0) * (p.max() - p.min() + 1)) - p.sum());
    }

    private int processPassBin(String rawPass) {
        var binString = rawPass.chars()
                .mapToObj(i ->(char) i)
                .map(c -> onBits.contains(c) ? "1" : "0")
                .collect(Collectors.joining(""));
        return Integer.parseInt(binString, 2);
    }

    record PartTwoAggregate(int min, int max, int sum){}
}

