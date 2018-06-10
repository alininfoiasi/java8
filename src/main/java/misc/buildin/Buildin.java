package main.java.misc.buildin;

import main.java.misc.interfaces.Converter;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Buildin {

    public static void test1() {
        // boolean-valued functions of one argument

        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

    public static void test2() {
        // accept one argument and produce a result; default methods can chain multiple functions together
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        // "123"
        backToString.apply("123");
    }

    public static void test3() {
        // doesn't accept arguments
        Supplier<Object> objectSupplier = Object::new;
        // new Object
        objectSupplier.get();
    }

    public static void test4() {
        // operations on a single input parameter
        Consumer<String> greeter = (o) -> System.out.println("Hello, " + o.toString());
        greeter.accept(new String("zero"));

        Consumer<Converter.Person> greeter2 = (p) -> System.out.println("Hello, " + p.firstName);
        greeter2.accept(new Converter.Person("Luke", "Skywalker"));
    }

    public static void test5() {
        Comparator<Converter.Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Converter.Person p1 = new Converter.Person("John", "Doe");
        Converter.Person p2 = new Converter.Person("Alice", "Wonderland");
        // > 0
        comparator.compare(p1, p2);
        // < 0
        comparator.reversed().compare(p1, p2);
    }

    public static void test6() {
        Optional<String> optional = Optional.of("foo");
        // true
        optional.isPresent();
        // "bam"
        optional.get();
        // "bar"
        optional.orElse("bar");

        // "f"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));
    }


    public static void main(String[] args) {
        Buildin.test1();
        Buildin.test2();
        Buildin.test3();
        Buildin.test4();
        Buildin.test5();
        Buildin.test6();
    }
}
