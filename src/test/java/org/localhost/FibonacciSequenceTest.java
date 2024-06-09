package org.localhost;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciSequenceTest {

    private final FibonacciSequence objectUnderTest = new FibonacciSequence();

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1,1,2), 10, List.of(1, 1, 2, 4, 7, 13, 24, 44, 81, 149)),
                Arguments.of(List.of(4, 7, 13), 15, List.of(4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513))
        );
    }

    private static Stream<Arguments> generateInvalidData() {
        return Stream.of(
                Arguments.of(List.of(1,2), 10),
                Arguments.of(List.of(1, 1, 2, 4), 10),
                Arguments.of(null, 10),
                Arguments.of(List.of(1,2, 2), 0),
                Arguments.of(List.of(1,2, 2), -1)
                );
    }


    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("It should generate valid fibonacci sequence")
    public void generateValidSequence(List<Integer> input, int size, List<Integer> expected) {
        //given
        List<Integer> result = objectUnderTest.generateSequence(input, size);
        //when
        assertEquals(expected, result);
        assertEquals(expected.size(), result.size());
    }

    @ParameterizedTest
    @MethodSource("generateInvalidData")
    @DisplayName("generateSequence should throw when given invalid arguments")
    public void generateSequenceInvalidArguments(List<Integer> input, int size) {
//        given
        assertThrows(IllegalArgumentException.class, () -> {
            objectUnderTest.generateSequence(input, size);
        });
    }
}