package io.hacksy.aoc.v2020.day10;

import io.hacksy.aoc.v2020.util.FileUtil;
import io.hacksy.aoc.v2020.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day10App {
    public static void main(String[] args) {
        var processor = new Day10Processor();

        File file = FileUtil.getResourceFile("input/day10/day10.txt");
        List<Integer> input = FileUtil.fileToList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 10 - Part 1: %s", processor.partOne(input)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 10 - Part 2: %s", processor.partTwo(input)));
    }
}
