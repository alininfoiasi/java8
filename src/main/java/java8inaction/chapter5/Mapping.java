package java8inaction.chapter5;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Mapping {

    public static void main(String[] args) {

        // use map to produce one value for each element in stream
        List<String> words = Arrays.asList("Java", "8", "in", "Action");
        List<Integer> wordLengths =
                words.stream()
                        .map(String::length)
                        .collect(Collectors.toList());
        System.out.println("-----");
        System.out.println(wordLengths);


        // use flatMap to produce an arbitrary number of values for each element in stream
        List<Character> uniqueCharacters =
                words.stream()
                        .map(word -> word.chars().mapToObj(i -> (char) i))
                        .flatMap((Stream<Character> s) -> s.distinct())
                        .collect(Collectors.toList());
        System.out.println("-----");
        System.out.println(uniqueCharacters);
    }
}
