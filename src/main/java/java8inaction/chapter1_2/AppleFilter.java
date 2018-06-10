package java8inaction.chapter1_2;

import java.util.*;
import java.util.function.Predicate;

// use behavior parametrization pattern to tackle verbosity
public class AppleFilter {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(120, "red"),
                new Apple(80, "green"),
                new Apple(150, "green"),
                new Apple(180, "green"),
                new Apple(160, "orange"),
                new Apple(100, "yellow")
        );

        List<Apple> greenApples1 = filterApples(inventory, a -> "green".equals(a.getColor()));
        System.out.println(greenApples1);

        List<Apple> heavyApples1 = filterApples(inventory, a -> a.getWeight() > 150);
        System.out.println(heavyApples1);

        List<Apple> greenHeavyApples1 = filterApples(inventory, a -> a.getWeight() > 150 && "green".equals(a.getColor()));
        System.out.println(greenHeavyApples1);


        List<Apple> greenApples2 = filterApples(inventory, AppleFilter::isGreenApple);
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, AppleFilter::isHeavyApple);
        System.out.println(heavyApples2);

        List<Apple> greenHeavyApples2 = filterApples(inventory, AppleFilter::isGreenHeavyApple);
        System.out.println(greenHeavyApples2);

        // composing predicates
        Predicate<Apple> greenApplePredicate = a -> a.getColor().equals("green");
        Predicate<Apple> notGreenApplePredicate = greenApplePredicate.negate();
        Predicate<Apple> lightApplePredicate = a -> a.getWeight() <= 150;
        Predicate<Apple> targetApplePredicate = notGreenApplePredicate.and(lightApplePredicate);
        List<Apple> targetApples = filterApples(inventory, targetApplePredicate);
        System.out.println(targetApples);

        // passing code to a thread to execute (since Runnable is a functional interface)
        Thread t = new Thread(() -> System.out.println("Hello java8 world!"));
        t.run();


        System.out.println(inventory);
        // passing code for sorting with a Comparator (since Comparator is a functional interface)
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        System.out.println("-----");

        // using method reference
        System.out.println(inventory);
        inventory.sort(Comparator.comparing(Apple::getColor));
        System.out.println(inventory);

        System.out.println("-----");

        // using comparator chaining
        System.out.println(inventory);
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println(inventory);

    }

    // first implementation of the strategy pattern
    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    // second implementation of the strategy pattern
    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    // third implementation of the strategy pattern
    public static boolean isGreenHeavyApple(Apple apple) {
        return isGreenApple(apple) && isHeavyApple(apple);
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
