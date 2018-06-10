package main.java.misc.interfaces.access;

import main.java.misc.interfaces.Converter;

public class Access {
    static int outerStaticNumber;
    int outerNumber;

    public void testAccess() {
        // default methods cannot be accessed from within misc.lambda expressions
        // misc.lambda body does not have access to any sort of 'this' reference
        // 'this' references the instance of the surrounding class
        // so misc.lambda cannot be referenced from inside the misc.lambda

        //Formula formula3 = (x) -> sqrt(x * 100);
        //System.out.println(formula3.sqrt(16));
    }

    public void test1(String s) {
        final int number = 1;
        int number1 = 1;
        // misc.lambda can access final local variables
        Converter<Integer, String> stringConverter1 = (from) -> String.valueOf(from + number);
        // misc.lambda can also access effectively final local variables
        Converter<Integer, String> stringConverter2 = (from) -> String.valueOf("" + from + number1);
        // misc.lambda cannot write into local variables
        System.out.println(stringConverter1.convert(2));
        System.out.println(stringConverter2.convert(2));

        // misc.lambda can do both read and write on instance fields
        Converter<Integer, String> stringConverter3 = (from) -> {
            outerStaticNumber = 10;
            outerNumber = 20;
            return String.valueOf("" + from + outerNumber);
        };
        System.out.println(stringConverter3.convert(2));
    }

    public static void main(String[] args) {
        Access access = new Access();
        access.test1("dummy");
    }
}
