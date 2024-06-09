package org.localhost;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        List<Integer> inputList = List.of(1,1,2);

        var result = fibonacciSequence.generateSequence(inputList, 10);
        System.out.println(result);
    }
}