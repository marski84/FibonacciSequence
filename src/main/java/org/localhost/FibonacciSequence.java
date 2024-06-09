package org.localhost;
import java.util.LinkedList;
import java.util.List;

public class FibonacciSequence {
    private static final int NUMBERS_COUNT = 3;
    private static final int MIN_SEQUENCE_LENGTH = 1;

    public List<Integer> generateSequence(List<Integer> list, int size) {
        validateInput(list, size);
        List<Integer> sequence = new LinkedList<>();
        int first = list.get(0);
        int second = list.get(1);
        int third = list.get(2);
        sequence.add(first);
        sequence.add(second);
        sequence.add(third);
//1, 1, 2, 4, 7, 13, 24, 44, 81, 149
//        użycie rozwiązania w pętli wynika z gorszej wydajności rekurencji w przypadku tego typu operacji
        for(int i = 3; i < size; i++) {
            sequence.add(sequence.get(i-1) + sequence.get((i-2))+ sequence.get(i-3));
        }
        return sequence;
    }

    private void validateInput(List<Integer> list, int sequenceLength) {
        if(list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        if (list.size() < NUMBERS_COUNT || list.size() > NUMBERS_COUNT) {
            throw new IllegalArgumentException("List must contain at least " + NUMBERS_COUNT + " elements");
        }
        if (sequenceLength < MIN_SEQUENCE_LENGTH) {
            throw new IllegalArgumentException("Minimum sequence length is " + MIN_SEQUENCE_LENGTH);
        }
    }
}

