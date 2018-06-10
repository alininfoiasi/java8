package java8inaction.chap11;

import static java8inaction.chap11.Util.delay;
import static java8inaction.chap11.Util.format;

public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }
    private static double apply(double price, Code code) {
        Util.delay();
        return Util.format(price * (100 - code.percentage) / 100);
    }
}