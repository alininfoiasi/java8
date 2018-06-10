package main.java.misc.stream;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class StreamTest {

    public List<String> stringCollection = new ArrayList<>();

    {
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    public void test1() {
        //
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    public void test2() {
        // parallel
        stringCollection
                .parallelStream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    public void test3() {
        // sorting returns a view; backed collection is not modified
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        System.out.println(stringCollection);
    }

    public void test4() {
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
    }

    public void test5() {
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        // true
        System.out.println(anyStartsWithA);

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        // false
        System.out.println(allStartsWithA);

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        // true
        System.out.println(noneStartsWithZ);
    }

    public void test6() {
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();
        // 3
        System.out.println(startsWithB);
    }

    public void test7() {
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "|" + s2);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
        reduced.ifPresent(System.out::println);
    }

    public void test8() {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        t0 = System.nanoTime();

        count = values.parallelStream().sorted().count();
        System.out.println(count);

        t1 = System.nanoTime();

        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));

    }

    public void test9() {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + (i*i));
        }

        map.forEach((id, val) -> System.out.println(val));
        System.out.println();

        // val93
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3));

        // false
        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9));

        // true
        map.computeIfAbsent(23, num -> "value" + num);
        System.out.println(map.containsKey(23));

        // val93
        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3));

        // val93
        map.remove(3, "val3");
        System.out.println(map.get(3));

        // null
        map.remove(3, "val93");
        System.out.println(map.get(3));

        // not found
        System.out.println(map.getOrDefault(42, "not found"));

        // newval
        map.merge(9, "newval", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));

        // newvalconcat
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));

    }

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        /*
        streamTest.test1();
        streamTest.test2();
        streamTest.test3();
        streamTest.test4();
        streamTest.test5();
        streamTest.test6();
        streamTest.test7();
        streamTest.test8();
        */
        streamTest.test9();
    }
}

