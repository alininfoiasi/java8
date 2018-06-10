package java8inaction.chapter6;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class CollectingNumbers {

    public static void main(String[] args) {
        System.out.println("Non-prime and prime numbers: " + partitionPrimes(30));
        System.out.println("Odd and even numbers: " + groupEvenOdd(10));
        System.out.println("Grouped by double value numbers: " + groupByDoubleValue(3));
    }

    public static boolean isPrime(int candidate) {
        return IntStream.rangeClosed(2, (int) Math.floor(Math.sqrt((double) candidate)))
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    public static Map<Boolean, List<Integer>> groupEvenOdd(int n) {
        return IntStream.rangeClosed(0, n).boxed()
                .collect(partitioningBy(candidate -> candidate % 2 == 0));
    }

    public static Map<Double, List<Integer>> groupByDoubleValue(int n) {
        return IntStream
                .concat(IntStream.rangeClosed(0, n), IntStream.rangeClosed(0, n * 2))
                .boxed()
                .collect(groupingBy(Number::doubleValue));
    }
}
