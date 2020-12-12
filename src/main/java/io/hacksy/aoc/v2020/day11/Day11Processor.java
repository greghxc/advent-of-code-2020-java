package io.hacksy.aoc.v2020.day11;


import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;

import java.util.Optional;
import java.util.function.Predicate;

public class Day11Processor {
    int partOne(List<String> input) {
        var seats = seats(input);
        var min = new Position(0, 0);
        var max = new Position(input.get(0).length() - 1, input.size() - 1);
        return stableSeatRes(seats, HashSet.empty(), min, max, 4, p -> true).size();
    }

    int partTwo(List<String> input) {
        var seats = seats(input);
        var min = new Position(0, 0);
        var max = new Position(input.get(0).length() - 1, input.size() - 1);
        return stableSeatRes(seats, HashSet.empty(), min, max, 5, seats::contains).size();
    }

    private Set<Position> stableSeatRes(
            Set<Position> seats, Set<Position> seated, Position min, Position max,
            int nearbyTolerance, Predicate<Position> visibility
    ) {
        Set<Position> newSeated = seated;
        for (Position pos : seats) {
            Predicate<Position> qualifier = visibility.and(p -> !pos.equals(p));
            var nearby = List.of(
                    getNext(pos, -1, -1, min, max, qualifier),
                    getNext(pos, 0, -1, min, max, qualifier),
                    getNext(pos, 1, -1, min, max, qualifier),
                    getNext(pos, -1, 0, min, max, qualifier),
                    getNext(pos, 1, 0, min, max, qualifier),
                    getNext(pos, -1, 1, min, max, qualifier),
                    getNext(pos, 0, 1, min, max, qualifier),
                    getNext(pos, 1, 1, min, max, qualifier))
                    .filter(p -> p.isPresent() && seated.contains(p.get()))
                    .size();
            if (seated.contains(pos)) {
                if (nearby >= nearbyTolerance) { newSeated = newSeated.remove(pos); }
            } else {
                if (nearby == 0) { newSeated = newSeated.add(pos); }
            }
        }
        if (newSeated.equals(seated)) {
            return newSeated;
        }
        return stableSeatRes(seats, newSeated, min, max, nearbyTolerance, visibility);
    }

    Set<Position> seats(List<String> input) {
        return List.range(0, input.get(0).length()).crossProduct(List.range(0, input.size()))
                .map(t -> new Position(t._1(), t._2()))
                .filter(p -> input.get(p.row()).charAt(p.col()) == 'L')
                .toSet();
    }

    Optional<Position> getNext(Position base, int colMod, int rowMod, Position min, Position max, Predicate<Position> qualifier) {
        if (qualifier.test(base)) {
            return Optional.of(base);
        }
        if (base.col() < min.col() || base.row() < min.row() || base.col() > max.col() || base.row() > max.row()) {
            return Optional.empty();
        }
        return getNext(
                new Position(base.col + colMod, base.row + rowMod),
                colMod, rowMod, min, max,
                qualifier
        );
    }

    record Position(int col, int row) {}
}
