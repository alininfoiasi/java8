package java8inaction.chapter3;

import java.util.function.Function;

public class FunctionChaining {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 5;

        // ( 2 + 1 ) * 5
        System.out.println(f.andThen(g).apply(2));

        // ( 2 * 5 ) + 1
        System.out.println(f.compose(g).apply(2));
    }

}
