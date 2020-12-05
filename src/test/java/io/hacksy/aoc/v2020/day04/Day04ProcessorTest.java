package io.hacksy.aoc.v2020.day04;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day04ProcessorTest {

    @Test
    void partOne() {
        var processor = new Day04Processor();
        List<String> input = List.of(
                "",
                ""
        );
        String expected = "";
        assertThat(processor.partOne(input)).isEqualTo(expected);
    }

    @Test
    void partTwo() {
        var processor = new Day04Processor();

        List<String> input = List.of(
            "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980 hcl:#623a2f",
            "eyr:2029 ecl:blu cid:129 byr:1989 iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
            "hcl:#888785 hgt:164cm byr:2001 iyr:2015 cid:88 pid:545766238 ecl:hzl eyr:2022",
            "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"
        );

        String expected = "4";
        assertThat(processor.partTwo(input)).isEqualTo(expected);
    }
}