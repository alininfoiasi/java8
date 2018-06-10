package java8inaction.chapter5;

import java8inaction.chapter4.*;

import java.util.*;

import static java8inaction.chapter4.Dish.menu;

public class ReduceOperations {

    public static void main(String[] args) {

        // stateful operations for result accumulation

        // with initial value
        List<Integer> numbers = Arrays.asList(5, 1, 2);
        int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum1);
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        // without initial value
        Optional<Integer> optionalMax = numbers.stream().reduce(Integer::max);
        optionalMax.ifPresent(System.out::println);
    }
}
