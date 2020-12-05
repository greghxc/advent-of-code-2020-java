package io.hacksy.aoc.v2020.day05;

import io.vavr.collection.List;

import static io.vavr.API.*;

public class Day05Processor {
    String partOne(List<String> input) {
        return Integer.toString(input.map(this::processPass).max().get());
    }

    String partTwo(List<String> input) {
         PartTwoAggregate p = input
                .map(this::processPass)
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

    private int processPass(String rawPass) {
        PassAggregate row = List.range(0, 7).
                foldLeft(new PassAggregate(0, 127), (agg, i) -> Match(rawPass.charAt(i)).of(
                        Case($('F'), () -> lower(agg)),
                        Case($('B'), () -> upper(agg)),
                        Case($(), () -> {
                            throw new RuntimeException("unexpected char for row");
                        })
                ));
        PassAggregate seat = List.range(7, 10).
                foldLeft(new PassAggregate(0, 7), (agg, i) -> Match(rawPass.charAt(i)).of(
                        Case($('L'), () -> lower(agg)),
                        Case($('R'), () -> upper(agg)),
                        Case($(), () -> {
                            throw new RuntimeException("unexpected char for seat");
                        })
                ));
        return row.floor * 8 + seat.floor;
    }

    private PassAggregate lower(PassAggregate agg) {
        return new PassAggregate(agg.floor(), agg.floor() + (agg.ceiling() - agg.floor()) / 2);
    }

    private PassAggregate upper(PassAggregate agg) {
        return new PassAggregate(agg.floor() + ((agg.ceiling() - agg.floor()) / 2) + 1, agg.ceiling());
    }

    record PassAggregate(int floor, int ceiling){}

    record PartTwoAggregate(int min, int max, int sum){}
}

