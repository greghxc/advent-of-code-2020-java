package io.hacksy.aoc.v2020.day04;

import io.vavr.collection.*;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Day04Processor {
    String partOne(List<String> input) {
        var valid = 0;
        for (String line : input) {
            Set<String> fieldKeys = HashSet.empty();
            for (String field : line.split(" ")) {
                var parsedField = field.split(":");
                fieldKeys = fieldKeys.add(parsedField[0]);
            }
            var finalKeys = fieldKeys;
            var keys = List.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
            if (keys.toStream().find(k -> !finalKeys.contains(k)).isEmpty()) { valid++; }
        }
        return Integer.toString(valid);
    }

    String partTwo(List<String> input) {
        var valid = 0;
        Pattern hgtPattern = Pattern.compile("^(\\d+)(cm|in)$");
        Pattern hclPattern = Pattern.compile("^#[0-9a-f]{6}$");
        Pattern eclPattern = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");
        Pattern pidPattern = Pattern.compile("^[0-9]{9}$");

        for (String line : input) {
            Map<String, String> fieldMap = HashMap.empty();
            for (String field : line.split(" ")) {
                var parsedField = field.split(":");
                fieldMap = fieldMap.put(parsedField[0], parsedField[1]);
            }

            var byr = fieldMap.get("byr").isDefined() &&
                    Integer.parseInt(fieldMap.get("byr").get()) >= 1920 &&
                    Integer.parseInt(fieldMap.get("byr").get()) <= 2002;

            var iyr = fieldMap.get("iyr").isDefined() &&
                    Integer.parseInt(fieldMap.get("iyr").get()) >= 2010 &&
                    Integer.parseInt(fieldMap.get("iyr").get()) <= 2020;

            var eyr = fieldMap.get("eyr").isDefined() &&
                    Integer.parseInt(fieldMap.get("eyr").get()) >= 2020 &&
                    Integer.parseInt(fieldMap.get("eyr").get()) <= 2030;

            var hcl = fieldMap.get("hcl").isDefined() &&
                    hclPattern.matcher(fieldMap.get("hcl").get()).find();

            var ecl = fieldMap.get("ecl").isDefined() &&
                    eclPattern.matcher(fieldMap.get("ecl").get()).find();

            var pid = fieldMap.get("pid").isDefined() &&
                    pidPattern.matcher(fieldMap.get("pid").get()).find();

            Predicate<String> hgtCheck = (str -> {
               var v = true;
               var m = hgtPattern.matcher(str);
               if (m.find()) {
                   if (m.group(2).equals("in")) {
                       if (Integer.parseInt(m.group(1)) < 59) { v = false; }
                       if (Integer.parseInt(m.group(1)) > 76) { v = false; }
                   }
                   if (m.group(2).equals("cm")) {
                       if (Integer.parseInt(m.group(1)) < 150) { v = false; }
                       if (Integer.parseInt(m.group(1)) > 193) { v = false; }
                   }
               } else {
                   v = false;
               }
               return v;
            });

            var hgt = fieldMap.get("hgt").isDefined() &&
                    hgtCheck.test(fieldMap.get("hgt").get());

            if (byr && iyr && eyr && hcl && ecl && pid && hgt) { valid++; }

        }
        return Integer.toString(valid);    }
}
