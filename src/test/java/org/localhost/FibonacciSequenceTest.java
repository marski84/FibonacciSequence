package org.localhost;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciSequenceTest {

    private final FibonacciSequence fibonacciSequence = new FibonacciSequence();

    @Test
    @DisplayName("It should return fibonacci sequence")
    public void itShouldReturnFibonacciSequenceWithValidSize() {
        List<Integer> inputList = List.of(1, 1, 2);
        int[] result = fibonacciSequence.generateSequence(inputList, 10);
        int[] expectedResult = {1, 1, 2, 4, 7, 13, 24, 44, 81, 149};

        assertEquals(result.length, expectedResult.length);
    }

    @Test
    @DisplayName("It should return fibonacci sequence")
    public void itShouldReturnValidFibonacciSequence() {
        List<Integer> inputList = List.of(4, 7, 13);
        int[] result = fibonacciSequence.generateSequence(inputList, 10);
        int[] expectedResult = {4, 7, 13, 24, 44, 81, 149, 274, 504, 927};

        assertEquals(result[result.length -1], expectedResult[result.length -1]);
    }

    @Test
    public void itShouldThrowWhenListArgumentHasTwoRecords() {
        List<Integer> inputList = List.of(1, 1);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fibonacciSequence.generateSequence(inputList, 10);
        });
    }

    @Test
    public void itShouldThrowWhenListArgumentHasFourRecords() {
        List<Integer> inputList = List.of(1, 1, 2, 4);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fibonacciSequence.generateSequence(inputList, 10);
        });
    }

    @Test
    public void itShouldThrowWhenListArgumentIsNull() {
        List<Integer> inputList = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fibonacciSequence.generateSequence(inputList, 10);
        });
    }

    @Test
    public void itShouldThrowWhenSizeArgumentToLow() {
        List<Integer> inputList = List.of(1, 1, 2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fibonacciSequence.generateSequence(inputList, 0);
        });
    }

    @Test
    public void itShouldThrowWhenSizeArgumentIsNegative() {
        List<Integer> inputList = List.of(1, 1, 2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            fibonacciSequence.generateSequence(inputList, -10);
        });
    }

}