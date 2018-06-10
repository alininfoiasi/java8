package java8inaction.chapter5;

import java8inaction.chapter4.*;

import java.util.*;

import static java8inaction.chapter4.Dish.menu;

public class MatchElements {

    public static void main(String[] args) {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        System.out.println("Menu is healthy 1:" + isHealthyMenu1());
        System.out.println("Menu is healthy 2:" + isHealthyMenu2());

        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    // next operations use short-circuit evaluation

    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu1() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }

}
