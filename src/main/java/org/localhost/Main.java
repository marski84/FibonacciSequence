package org.localhost;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        List<Integer> inputList = List.of(1, 1, 2);

        fibonacciSequence.generateSequence(inputList, 10);
    }
}