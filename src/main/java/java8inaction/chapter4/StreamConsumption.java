package java8inaction.chapter4;

import java.util.*;
import java.util.stream.*;

public class StreamConsumption {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java", "8", "in", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        // IllegalStateException: streams can only be consumed once, like iterators
        //s.forEach(System.out::println);
    }
}