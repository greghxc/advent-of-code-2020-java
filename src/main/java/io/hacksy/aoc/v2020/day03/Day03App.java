package io.hacksy.aoc.v2020.day03;

import io.hacksy.aoc.v2020.util.FileUtil;
import io.hacksy.aoc.v2020.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day03App {
    public static void main(String[] args) {
        var processor = new Day03Processor();

        File file = FileUtil.getResourceFile("input/day03/day03.txt");
        List<String> strings = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 03 - Part 1: %s", processor.partOne(strings)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 03 - Part 2: %s", processor.partTwo(strings)));
    }
}
