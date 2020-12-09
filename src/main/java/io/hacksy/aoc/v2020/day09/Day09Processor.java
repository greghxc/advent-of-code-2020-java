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
        var window = findWindow(new Window(0, 0, longs.get(0)), longs, getInvalidNumber(longs));
        var seq = longs.subSequence(window.left(), window.right() + 1);
        return seq.min().get() + seq.max().get();
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

    private Window findWindow(Window w, List<Long> input, long target) {
        while (w.sum() != target) {
            w = w.sum() > target
                    ? new Window(w.left() + 1, w.right(), w.sum() - input.get(w.left()))
                    : new Window(w.left(), w.right() + 1, w.sum() + input.get(w.right() + 1));
        }
        return w;
    }

    record Window(int left, int right, long sum) {}
}
