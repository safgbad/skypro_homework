package pro.sky.course2.hw16.utility;

import pro.sky.course2.hw16.transport.Transport;

import java.util.ArrayList;

public class TransportGenerator<T extends Transport> {
    private static final int ALPHABET_BEGIN = 'a';
    private static final int ALPHABET_END = 'z';

    private final int maxBrandLength;
    private final int maxModelLength;
    private final double minEngineVolume;
    private final double maxEngineVolume;
    private final Class<T> CLASS;

    public TransportGenerator(int maxBrandLength, int maxModelLength,
                              double minEngineVolume, double maxEngineVolume, Class<T> CLASS) {
        this.maxBrandLength = Math.max(maxBrandLength, 3);
        this.maxModelLength = Math.max(maxModelLength, 3);
        this.minEngineVolume = Math.max(minEngineVolume, 0);
        this.maxEngineVolume = maxEngineVolume > this.minEngineVolume ?
                maxEngineVolume : this.minEngineVolume + 2;
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
        int brandLength = (int) (1 + maxBrandLength * Math.random());
        char[] brand_char = new char[brandLength];
        fillArray(brand_char);
        String brand = new String(brand_char);
        int modelLength = (int) (1 + maxModelLength * Math.random());
        char[] model_char = new char[modelLength];
        fillArray(model_char);
        String model = new String(model_char);
        Double engineVolume = minEngineVolume + (maxEngineVolume - minEngineVolume) * Math.random();
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
