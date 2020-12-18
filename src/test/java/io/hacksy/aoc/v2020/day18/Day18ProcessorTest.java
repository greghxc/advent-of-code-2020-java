package io.hacksy.aoc.v2020.day18;

import io.vavr.collection.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day18ProcessorTest {
    @Test
    void partOne() {
        var processor = new Day18Processor();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(processor.partOne(List.of("1 + 2 * 3 + 4 * 5 + 6"))).isEqualTo(71L);
            softly.assertThat(processor.partOne(List.of("2 * 3 + (4 * 5)"))).isEqualTo(26L);
            softly.assertThat(processor.partOne(List.of("5 + (8 * 3 + 9 + 3 * 4 * 3)"))).isEqualTo(437L);
            softly.assertThat(processor.partOne(List.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"))).isEqualTo(12240L);
            softly.assertThat(processor.partOne(List.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"))).isEqualTo(13632L);
        });
    }

    @Test
    void partTwo() {
        var processor = new Day18Processor();
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(processor.partTwo(List.of("1 + (2 * 3) + (4 * (5 + 6))"))).isEqualTo(51L);
            softly.assertThat(processor.partTwo(List.of("2 * 3 + (4 * 5)"))).isEqualTo(46L);
            softly.assertThat(processor.partTwo(List.of("5 + (8 * 3 + 9 + 3 * 4 * 3)"))).isEqualTo(1445L);
            softly.assertThat(processor.partTwo(List.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"))).isEqualTo(669060L);
            softly.assertThat(processor.partTwo(List.of("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"))).isEqualTo(23340L);
        });
    }
}