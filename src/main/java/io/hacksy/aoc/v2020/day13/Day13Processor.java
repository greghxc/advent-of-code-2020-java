package io.hacksy.aoc.v2020.day13;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;

public class Day13Processor {
    long partTwo(List<String> input) {
        var schedules =  List.of(input.get(1).split(","))
                .zipWithIndex()
                .filter(t -> !t._1().equals("x"))
                .map(t -> Tuple.of(Long.parseLong(t._1()), t._2()));
        return recursive(0L, 0, schedules);
    }

    long recursive(long position, int schedIndex, List<Tuple2<Long, Integer>> schedules) {
        if (schedIndex >= schedules.size()) { return position; }
        var nextPosition = position + schedules.subSequence(0,schedIndex).map(Tuple2::_1).product().longValue();
        var mod = (nextPosition + schedules.get(schedIndex)._2()) % schedules.get(schedIndex)._1();
        var nextSchedIndex = mod == 0 ? schedIndex + 1 : schedIndex;
        return recursive(nextPosition, nextSchedIndex, schedules);
    }
}
