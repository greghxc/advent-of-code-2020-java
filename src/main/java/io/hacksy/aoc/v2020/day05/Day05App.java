package io.hacksy.aoc.v2020.day05;

import io.hacksy.aoc.v2020.util.FileUtil;
import io.hacksy.aoc.v2020.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day05App {
    public static void main(String[] args) {
        var processor = new Day05Processor();

        File file = FileUtil.getResourceFile("input/day05/day05.txt");
        List<String> strings = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 04 - Part 1: %s", processor.partOne(strings)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 04 - Part 2: %s", processor.partTwo(strings)));
    }
}
