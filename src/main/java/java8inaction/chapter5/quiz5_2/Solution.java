package java8inaction.chapter5.quiz5_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5);
        List<Integer> squareNumbers =
                numbers.stream()
                        .map(n -> n * n)
                        .collect(Collectors.toList());
        System.out.println(squareNumbers);


        List<Integer> list1 = Arrays.asList(0, 1, 2);
        List<Integer> list2 = Arrays.asList(8, 9);

        List<Pair> pairs =
                list1
                        .stream()
                        .flatMap(e1 ->list2
                                .stream()
                                .map(e2 -> new Pair<>(e1, e2))).collect(Collectors.toList());
        System.out.println(pairs);
    }
}
