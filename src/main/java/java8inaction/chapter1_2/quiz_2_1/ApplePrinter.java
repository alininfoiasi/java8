package java8inaction.chapter1_2.quiz_2_1;

import java8inaction.chapter1_2.Apple;

@FunctionalInterface
public interface ApplePrinter {
    String prettyPrint(Apple apple);
}
