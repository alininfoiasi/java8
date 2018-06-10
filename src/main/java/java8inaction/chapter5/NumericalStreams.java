package java8inaction.chapter5;

import java8inaction.chapter4.*;

import java.util.stream.*;
import java.util.*;

import static java8inaction.chapter4.Dish.menu;

public class NumericalStreams {

    public static void main(String[] args) {

        // infinite streams
        Stream.iterate(0, n -> n + 10)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("-----");

        // generate Fibonacci series
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        System.out.println("-----");

        // generate random numbers
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // numeric ranges
        IntStream evenNumbers =
                IntStream
                        .range(1, 10)
                        .filter(n -> n % 2 == 0);
        System.out.println("-----");
        System.out.println(evenNumbers.boxed().collect(Collectors.toList()));

        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 20).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 20)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        System.out.println("-----");
        pythagoreanTriples.forEach(t -> System.out.println("[" + t[0] + ", " + t[1] + ", " + t[2] + "]"));

    }

}
