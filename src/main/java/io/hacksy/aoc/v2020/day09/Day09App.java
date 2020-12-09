package io.hacksy.aoc.v2020.day09;

import io.hacksy.aoc.v2020.util.FileUtil;
import io.hacksy.aoc.v2020.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;
import java.io.IOException;

public class Day09App {
    public static void main(String[] args) throws IOException {
        var processor = new Day09Processor(25);

        File file = FileUtil.getResourceFile("input/day09/day09.txt");
        List<String> input = FileUtil.fileToStringList(file);

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 09 - Part 1: %s", processor.partOne(input)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 09 - Part 2: %s", processor.partTwo(input)));
    }
}
