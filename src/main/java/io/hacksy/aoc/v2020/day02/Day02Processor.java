package io.hacksy.aoc.v2020.day02;

import io.vavr.collection.List;

import java.util.regex.Pattern;

public class Day02Processor {
    static final Pattern PATTERN = Pattern.compile("");

    int partOne(List<String> input) {
        return input
                .map(this::parsePasswordProfile)
                .filter(pp -> {
                    var charCount = List.ofAll(pp.password().chars().boxed())
                            .filter(c -> c == pp.reqChar())
                            .count(c -> true);
                    return charCount >= pp.lower() && charCount <= pp.upper();
                })
                .size();
    }

    int partTwo(List<String> input) {
        return input
                .map(this::parsePasswordProfile)
                .filter(pp -> {
                    var firstChar = pp.password().charAt(pp.lower() - 1);
                    var secondChar = pp.password().charAt(pp.upper() - 1);
                    return firstChar == pp.reqChar() ^ secondChar == pp.reqChar();
                })
                .size();
    }

    PasswordProfile parsePasswordProfile(String line) {
        var m = PATTERN.matcher(line);
        if (m.find()) {
            return new PasswordProfile(
                    Integer.parseInt(m.group(1)),
                    Integer.parseInt(m.group(2)),
                    m.group(3).charAt(0),
                    m.group(4)
            );
        } else {
            throw new RuntimeException("Unparseable!");
        }
    }

    record PasswordProfile (
        int lower, int upper, char reqChar, String password
    ) {}
}
