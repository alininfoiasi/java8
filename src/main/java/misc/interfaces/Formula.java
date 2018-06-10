package main.java.misc.interfaces;

public interface Formula {
    double calculate(int x);

    // non-abstract, default method, aka extension method
    default double sqrt(int x) {
        return Math.sqrt(x);
    }

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int x) {
                return sqrt(x * 100);
            }
        };

        Formula formula2 = new Formula() {
            @Override
            public double calculate(int x) {
                return sqrt(x * 100);
            }
            @Override
            public double sqrt(int x) {
                return Math.sqrt(x * 10);
            }
        };

        int x = 16;
        System.out.println(formula.calculate(x));
        System.out.println(formula.sqrt(x));
        System.out.println(formula2.calculate(x));
        System.out.println(formula2.sqrt(x));
    }
}