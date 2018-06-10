package java8inaction.chapter5.quiz5_2;

public class Pair<T> {
    private T element1;
    private T element2;

    public Pair(T element1, T element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "element1=" + element1 +
                ", element2=" + element2 +
                '}';
    }
}
