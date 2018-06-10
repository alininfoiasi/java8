package java8inaction.chapter4;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class StreamBasic {

    public static void main(String[] args) {
        getHighCaloricDishNames(Dish.menu).forEach(System.out::println);
        System.out.println("-----");
        getSomeHighCaloricDishNames(Dish.menu).forEach(System.out::println);
        System.out.println("-----");
        System.out.println(countHighCaloricDishes(Dish.menu));
    }

    public static List<String> getHighCaloricDishNames(List<Dish> dishes) {
        // similar to the builder pattern
        // lazy evaluation
        return dishes.stream()
                .filter(d -> {
                    System.out.println("Filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("Mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .sorted()
                .collect(toList());
    }

    public static Long countHighCaloricDishes(List<Dish> dishes) {
        // uses intermediate operations (that transforms a stream into another stream) and final operations (collect, count, println)
        return dishes.stream()
                .filter(d -> {
                    System.out.println("Filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("Mapping " + d.getName());
                    return d.getName();
                })
                .count();
    }

    public static List<String> getSomeHighCaloricDishNames(List<Dish> dishes) {
        // similar to the builder pattern
        // lazy evaluation
        return dishes.stream()
                .filter(d -> {
                    System.out.println("Filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .skip(2)
                .map(d -> {
                    System.out.println("Mapping " + d.getName());
                    return d.getName();
                })
                .sorted()
                .collect(toList());
    }
}
