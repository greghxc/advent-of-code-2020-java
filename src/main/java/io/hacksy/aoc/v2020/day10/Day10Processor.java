package io.hacksy.aoc.v2020.day10;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;

public class Day10Processor {
    int partOne(List<Integer> input) {
        var sorted = input.append(0).sorted();
        Map<Integer, Integer> diffMap = List.range(1, sorted.size())
                .foldLeft(HashMap.empty(), (map, i) -> {
                    var diff = sorted.get(i) - sorted.get(i - 1);
                    return map.put(diff, map.getOrElse(diff, 0) + 1);
                });
        return diffMap.get(1).get() * (diffMap.get(3).get() + 1);
    }

    long partTwo(List<Integer> input) {
        return getArrangements(input.append(0).sorted(), List.fill(input.size() + 1, 0L).update(0, 1L));
    }

    private long getArrangements(List<Integer> sortedAdaptors, List<Long> register) {
        if (sortedAdaptors.length() == 1) {
            return register.get(0);
        }
        return getArrangements(
                sortedAdaptors.subSequence(1),
                List.range(1,Math.min(sortedAdaptors.length(), 4))
                        .foldLeft(register, (reg, i) -> {
                            var addl = sortedAdaptors.get(i) <= sortedAdaptors.get(0) + 3 ? reg.get(0) : 0;
                            return reg.update(i, reg.get(i) + addl);
                        }).subSequence(1));
    }
}
