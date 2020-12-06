package io.hacksy.aoc.v2020.day06;

import io.hacksy.aoc.v2020.util.FileUtil;
import io.hacksy.aoc.v2020.util.PerfUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day06App {
    public static void main(String[] args) throws IOException {
        var processor = new Day06Processor();

        File file = FileUtil.getResourceFile("input/day06/day06.txt");
        String inputString = Files.readString(Paths.get(file.toURI()));

        var times = 1;
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 06 - Part 1: %s", processor.partOne(inputString)));
        PerfUtil.timeAndPrintRepeated(times, () ->
                String.format("Day 06 - Part 2: %s", processor.partTwo(inputString)));
    }
}
