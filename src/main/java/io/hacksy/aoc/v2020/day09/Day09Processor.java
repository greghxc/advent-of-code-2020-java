package io.hacksy.aoc.v2020.day09;

import io.vavr.collection.List;

public class Day09Processor {
    private final int prefixLength;

    public Day09Processor(int prefixLength) {
        this.prefixLength = prefixLength;
    }

    long partOne(List<String> input) {
        return getInvalidNumber(input.map(Long::parseLong));
    }

    long partTwo(List<String> input) {
        var longs = input.map(Long::parseLong);
        var window = findWindow(longs, getInvalidNumber(longs));
        var seq = longs.subSequence(window.left(), window.right() + 1);
        return seq.min().get() + seq.max().get();
    }

    Window findWindow(List<Long> input, long target) {
        var window = new Window(0, 0, input.get(0));
        while (window.sum != target) {
            window = new Window(
                    window.sum() > target
                            ? window.left() + 1
                            : window.left(),
                    window.sum() > target
                            ? window.right()
                            : window.right() + 1,
                    window.sum() > target
                            ? window.sum() - input.get(window.left())
                            : window.sum() + input.get(window.right() + 1)
            );
        }
        return window;
    }

    private long getInvalidNumber(List<Long> longs) {
        return longs.zipWithIndex()
                .toStream()
                .subSequence(prefixLength)
                .find(t -> !longs.subSequence(t._2() - prefixLength, t._2())
                        .crossProduct().map(prod -> prod._1() + prod._2())
                        .toSet().contains(t._1())
                )
                .get()._1();
    }

    record Window(int left, int right, long sum) {}
}
