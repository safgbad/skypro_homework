package sky.pro.java.course2.hw16.transport.enums;

public enum Body {
    SEDAN("Седан"),
    HATCHBACK("Хэтчбэк"),
    COUPE("Купе"),
    STATION_WAGON("Универсал"),
    SUV("Внедорожник"),
    CUV("Кроссовер"),
    PICKUP_TRUCK("Пикап"),
    VAN("Фургон"),
    MINIVAN("Минивэн");


    private final String body;

    Body(String body) {
        this.body = body;
    }

    public static Body getRandom() {
        Body[] values = Body.values();
        int index = (int) (values.length * Math.random());
        return values[index];
    }

    @Override
    public String toString() {
        return "Тип кузова: " + body;
    }
}
