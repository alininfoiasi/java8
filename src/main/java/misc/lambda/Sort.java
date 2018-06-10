package main.java.misc.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void classicSort(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
    }

    public static void lambdaSort1(List<String> names) {
        Collections.sort(names,
                (String a, String b) ->
                {
                    return b.compareTo(a);
                }
                );
    }

    public static void lambdaSort2(List<String> names) {
        Collections.sort(names,
                (String a, String b) -> b.compareTo(a)
        );
    }

    public static void lambdaSort3(List<String> names) {
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Peter", "Anna", "Joe", "Jane", "Bob");
        classicSort(names);
        System.out.println("Sorted list of names: " + names.toString());
        names = Arrays.asList("Peter", "Anna", "Joe", "Jane", "Bob");
        lambdaSort1(names);
        System.out.println("Sorted list of names: " + names.toString());
        names = Arrays.asList("Peter", "Anna", "Joe", "Jane", "Bob");
        lambdaSort2(names);
        System.out.println("Sorted list of names: " + names.toString());
        names = Arrays.asList("Peter", "Anna", "Joe", "Jane", "Bob");
        lambdaSort3(names);
        System.out.println("Sorted list of names: " + names.toString());
    }
}
