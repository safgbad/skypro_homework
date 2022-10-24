package sky.pro.java.course2.hw14;

public interface Moveable {
    default void updateTyre() {
        System.out.println("Меняем покрышку");
    }

    default void checkEngine() {}
    default void checkTrailer() {}
}