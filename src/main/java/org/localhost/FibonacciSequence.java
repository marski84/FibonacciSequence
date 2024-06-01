package org.localhost;

import java.math.BigInteger;
import java.util.List;

public class FibonacciSequence {
    private final int NUMBERS_COUNT = 3;
//    tutaj nie wiem które z rozwiązań jest bardziej prawiwdłowe- czy private final czy BigInterger.ONE
    private final int MIN_SEQUENCE_LENGTH = 1;

    public int[] generateSequence(List<Integer> list, int size) {
        validateInput(list, size);
        int[] sequence = new int[size];
        int first = list.get(0);
        int second = list.get(1);
        int third = list.get(2);
        sequence[0] = first;
        sequence[1] = second;
        sequence[2] = third;
//1, 1, 2, 4, 7, 13, 24, 44, 81, 149
//        użycie rozwiązania w pętli wynika z gorszej wydajności rekurencji w przypadku tego typu operacji
        for(int i = 3; i < size; i++) {
            sequence[i] = sequence[i-1] + sequence[i-2] + sequence[i-3];
        }
//        System.out.println(sequence);
        return sequence;
    }

    private void validateInput(List<Integer> list, int sequenceLength) {
        if(list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }



        if (list.size() < NUMBERS_COUNT || list.size() > NUMBERS_COUNT) {
            throw new IllegalArgumentException("List must contain at least " + NUMBERS_COUNT + " elements");
        }

        if (sequenceLength < Integer.valueOf(String.valueOf(BigInteger.ONE))) {
            throw new IllegalArgumentException("Minimum sequence length is " + BigInteger.ONE);
        }
    }
}

