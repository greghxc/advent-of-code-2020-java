package io.hacksy.aoc.v2020.day02;

import io.hacksy.aoc.v2020.util.FileUtil;
import io.hacksy.aoc.v2020.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day02App {
    public static void main(String[] args) {
        var processor = new Day02Processor();

        File file = FileUtil.getResourceFile("input/day02/day02.txt");
        List<String> strings = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 02 - Part 1: %s", processor.partOne(strings)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 02 - Part 2: %s", processor.partTwo(strings)));
    }
}
