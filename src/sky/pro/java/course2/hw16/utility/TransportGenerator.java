package sky.pro.java.course2.hw16.utility;

import sky.pro.java.course2.hw16.Transport;

import java.util.ArrayList;

public class TransportGenerator<T extends Transport> {
    private static final int ALPHABET_BEGIN = 'a';
    private static final int ALPHABET_END = 'z';

    private final int MAX_BRAND_LENGTH;
    private final int MAX_MODEL_LENGTH;
    private final double MIN_ENGINE_VOLUME;
    private final double MAX_ENGINE_VOLUME;
    private final Class<T> CLASS;

    public TransportGenerator(int MAX_BRAND_LENGTH, int MAX_MODEL_LENGTH,
                              double MIN_ENGINE_VOLUME, double MAX_ENGINE_VOLUME, Class<T> CLASS) {
        this.MAX_BRAND_LENGTH = Math.max(MAX_BRAND_LENGTH, 3);
        this.MAX_MODEL_LENGTH = Math.max(MAX_MODEL_LENGTH, 3);
        this.MIN_ENGINE_VOLUME = Math.max(MIN_ENGINE_VOLUME, 0);
        this.MAX_ENGINE_VOLUME = MAX_ENGINE_VOLUME > this.MIN_ENGINE_VOLUME ?
                MAX_ENGINE_VOLUME : this.MIN_ENGINE_VOLUME + 2;
        this.CLASS = CLASS;
    }

    public ArrayList<T> generateVehicles(int number) {
        ArrayList<T> arr = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            arr.add(generate());
        }
        return arr;
    }

    private T generate() {
        int brandLength = (int) (1 + MAX_BRAND_LENGTH * Math.random());
        char[] brand_char = new char[brandLength];
        fillArray(brand_char);
        String brand = new String(brand_char);
        int modelLength = (int) (1 + MAX_MODEL_LENGTH * Math.random());
        char[] model_char = new char[modelLength];
        fillArray(model_char);
        String model = new String(model_char);
        Double engineVolume = MIN_ENGINE_VOLUME + (MAX_ENGINE_VOLUME - MIN_ENGINE_VOLUME) * Math.random();
        try {
             return CLASS.getConstructor(String.class, String.class, Double.class).
                    newInstance(brand, model, engineVolume);
        } catch (Exception e) {
            return null;
        }
    }

    private void fillArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (ALPHABET_BEGIN + (ALPHABET_END - ALPHABET_BEGIN + 1) * Math.random());
        }
        arr[0] = Character.toUpperCase(arr[0]);
    }

    public static void check(Transport transport) {
        if (transport == null) {
            System.out.println("Нулевой объект – невозможно выполнить проверку");
        } else {
            transport.startMoving();
            transport.stopMoving();
            transport.pitStop();
            transport.showBestLapTime();
            transport.showMaxSpeed();
        }
    }
}
