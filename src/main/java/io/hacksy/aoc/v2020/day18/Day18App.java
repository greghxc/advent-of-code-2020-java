package io.hacksy.aoc.v2020.day18;

import io.hacksy.aoc.v2020.util.FileUtil;
import io.hacksy.aoc.v2020.util.PerfUtil;

import java.io.File;

public class Day18App {
    public static void main(String[] args) {
        var processor = new Day18Processor();

        File file = FileUtil.getResourceFile("input/day18/day18.txt");
        var input = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 18 - Part 1: %s", processor.partOne(input)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 18 - Part 2: %s", processor.partTwo(input)));
    }
}
