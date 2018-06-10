package java8inaction.chapter3;

public class ConstructorReference {

    public static void main(String[] args) {
        QuadFunction<Integer, Integer, Integer, String, Color> colorFactory = Color::new;
        Color blackColor = colorFactory.apply(0, 0, 0, "black");
        Color whiteColor = colorFactory.apply(255, 255, 255, "white");
        System.out.println(blackColor);
        System.out.println(whiteColor);
    }
}
