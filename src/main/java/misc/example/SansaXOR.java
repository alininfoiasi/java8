package main.java.misc.example;

import java.util.*;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/sansa-and-xor/problem

public class SansaXOR {
    int n;

    public int printCounter() {
        return IntStream.range(1, (n+1))
                .filter(i -> ( n % 2 == 1 && i % 2 == 1) )
                .reduce(0, (a,b) -> a ^ b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SansaXOR solution = new SansaXOR();
        solution.n = scanner.nextInt();
        System.out.println("Solution is: " + solution.printCounter());
    }
}