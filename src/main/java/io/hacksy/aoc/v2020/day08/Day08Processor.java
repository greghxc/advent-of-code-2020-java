package io.hacksy.aoc.v2020.day08;

import io.vavr.Tuple;
import io.vavr.collection.*;

public class Day08Processor {

    public static final Map<String, String> TRANSLATION_MAP = HashMap.of("jmp", "nop", "nop", "jmp");

    int partOne(List<String> input) {
        return runProgram(0, 0, HashSet.empty(), parseProgram(input)).acc;
    }

    int partTwo(List<String> input) {
        var program = parseProgram(input);
        return program.zipWithIndex()
                .filter(t -> TRANSLATION_MAP.keySet().contains(program.get(t._2).command()))
                .map(t -> program.update(t._2, new instruction(TRANSLATION_MAP.get(t._1.command).get(), t._1.value)))
                .append(program)
                .toStream()
                .map(p -> runProgram(0, 0, HashSet.empty(), p))
                .find(result -> !result.isLoop()).get().acc();
    }

    result runProgram(int acc, int position, Set<Integer> seen, List<instruction> input) {
        if (seen.contains(position)) { return new result(true, acc); }
        if (position == input.length()) { return new result(false, acc); }
        var instruction = input.get(position);
        return runProgram(
                instruction.command.equals("acc") ? acc + instruction.value : acc,
                instruction.command.equals("jmp") ? position + instruction.value : position + 1,
                seen.add(position),
                input
        );
    }

    List<instruction> parseProgram(List<String> input) {
        return input
                .map(l -> l.split(" "))
                .map(sa -> new instruction(sa[0], Integer.parseInt(sa[1])));
    }

    record instruction(String command, int value){}

    record result(boolean isLoop, int acc){}
}
