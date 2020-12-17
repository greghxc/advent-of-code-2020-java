package io.hacksy.aoc.v2020.day17;

import io.vavr.collection.CharSeq;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

public class Day17Processor {
    int partOne(List<String> input) {
        Set<Cube> activeCubes = input.zipWithIndex()
                .flatMap(yt -> CharSeq.of(yt._1()).zipWithIndex()
                    .filter(xt -> xt._1() == '#')
                    .map(xt -> new Cube(xt._2(), yt._2(), 0))
                ).toSet();
        return solveProblem(activeCubes, this::getNeighbors);
    }

    int partTwo(List<String> input) {
        Set<HyperCube> activeCubes = input.zipWithIndex()
                .flatMap(yt -> CharSeq.of(yt._1()).zipWithIndex()
                        .filter(xt -> xt._1() == '#')
                        .map(xt -> new HyperCube(xt._2(), yt._2(), 0, 0))
                ).toSet();
        return solveProblem(activeCubes, this::getNeighbors);
    }

    <T> int solveProblem(Set<T> activeHyperCubes, Function<T, Set<T>> getNeighbors) {
        for (int i = 0; i < 6; i++) {
            Deque<T> cubeDeque = new ArrayDeque<>(activeHyperCubes.toJavaSet());
            Set<T> seen = HashSet.ofAll(activeHyperCubes);
            Set<T> nextActiveHyperCubes = activeHyperCubes;

            while (!cubeDeque.isEmpty()) {
                T cube = cubeDeque.remove();
                Set<T> neighbors = getNeighbors.apply(cube);
                int activeNeighbors = neighbors.intersect(activeHyperCubes).length();
                if (activeHyperCubes.contains(cube)) {
                    cubeDeque.addAll(neighbors.removeAll(seen).toJavaSet());
                    if (activeNeighbors != 2 && activeNeighbors != 3) {
                        nextActiveHyperCubes = nextActiveHyperCubes.remove(cube);
                    }
                } else {
                    if (activeNeighbors == 3) {
                        nextActiveHyperCubes = nextActiveHyperCubes.add(cube);
                    }
                }
            }
            activeHyperCubes = nextActiveHyperCubes;
        }

        return activeHyperCubes.size();
    }

    private Set<Cube> getNeighbors(Cube base) {
        Set<Cube> neighbors = HashSet.empty();
        for (long x = base.x() - 1; x <= base.x() + 1; x++) {
            for (long y = base.y() - 1; y <= base.y() + 1; y++) {
                for (long z = base.z() - 1; z <= base.z() + 1; z++) {
                    neighbors = neighbors.add(new Cube(x, y, z));
                }
            }
        }
        return neighbors.remove(base);
    }

    private Set<HyperCube> getNeighbors(HyperCube base) {
        Set<HyperCube> neighbors = HashSet.empty();
        for (long x = base.x() - 1; x <= base.x() + 1; x++) {
            for (long y = base.y() - 1; y <= base.y() + 1; y++) {
                for (long z = base.z() - 1; z <= base.z() + 1; z++) {
                    for (long w = base.w() - 1; w <= base.w() + 1; w++) {
                        neighbors = neighbors.add(new HyperCube(x, y, z, w));

                    }
                }
            }
        }
        return neighbors.remove(base);
    }
}

record Cube(long x, long y, long z) {}
record HyperCube(long x, long y, long z, long w) {}