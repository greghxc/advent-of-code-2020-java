package io.hacksy.aoc.v2020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    boolean testVal;

    @BeforeEach
    public void setUp() {
        testVal = true;
    }

    @Test
    public void test01() {
        assertThat(testVal).isTrue();
    }
}
