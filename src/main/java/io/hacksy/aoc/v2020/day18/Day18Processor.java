package io.hacksy.aoc.v2020.day18;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;

import java.util.ArrayDeque;
import java.util.Deque;

public class Day18Processor {
    long partOne(List<String> input){
        return input
                .map(s -> toPostfix(s, HashMap.of('*', 1, '+', 1, '(', 0)))
                .map(this::postFixCalculator)
                .sum().longValue();
    }

    long partTwo(List<String> input){
        return input
                .map(s -> toPostfix(s, HashMap.of('*', 1, '+', 2, '(', 0)))
                .map(this::postFixCalculator)
                .sum().longValue();
    }

    String toPostfix(String infix, Map<Character, Integer> precedenceWeight) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : infix.replace(" ", "").toCharArray()) {
            switch (c) {
                case '(' -> stack.push(c);
                case ')' -> {
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                case '+' -> {
                    while (!stack.isEmpty() && precedenceWeight.get(c).get() <= precedenceWeight.get(stack.peek()).get()) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
                case '*' -> {
                    while (!stack.isEmpty() && precedenceWeight.get(c).get() <= precedenceWeight.get(stack.peek()).get()) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
                default -> sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    long postFixCalculator(String postfix) {
        Deque<Long> stack = new ArrayDeque<>();
        for (char c : postfix.toCharArray()) {
            switch (c) {
                case '*' -> stack.push(stack.pop() * stack.pop());
                case '+' -> stack.push(stack.pop() + stack.pop());
                default -> stack.push(Long.parseLong(Character.toString(c)));
            }
        }
        return stack.pop();
    }
}
