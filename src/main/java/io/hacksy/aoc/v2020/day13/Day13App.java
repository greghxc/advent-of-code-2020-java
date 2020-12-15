package io.hacksy.aoc.v2020.day13;

import io.hacksy.aoc.v2020.util.FileUtil;
import io.hacksy.aoc.v2020.util.PerfUtil;
import io.vavr.collection.List;

import java.io.File;

public class Day13App {
    public static void main(String[] args) {
        var processor = new Day13Processor();


        File file = FileUtil.getResourceFile("input/day13/day13.txt");
        List<String> input = FileUtil.fileToStringList(file);
        var times = 1;

        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 13 - Part 2: %s", processor.partTwo(input)));
    }
}
