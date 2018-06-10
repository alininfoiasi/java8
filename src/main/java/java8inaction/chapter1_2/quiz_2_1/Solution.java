package java8inaction.chapter1_2.quiz_2_1;

import java8inaction.chapter1_2.Apple;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(150, "green"),
                new Apple(180, "green"),
                new Apple(160, "orange"),
                new Apple(120, "red"),
                new Apple(100, "yellow")
        );
        prettyPrintApple(inventory, a -> a.getColor());
        prettyPrintApple(inventory, a -> Integer.toString(a.getWeight()));
        prettyPrintApple(inventory, a -> a.getColor() + " - " + a.getWeight());
    }

    public static void prettyPrintApple(List<Apple> inventory, ApplePrinter applePrinter) {
        for (Apple apple : inventory) {
            String output = applePrinter.prettyPrint(apple);
            System.out.println(output);
        }
    }

}
