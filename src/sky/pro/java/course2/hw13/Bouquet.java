package sky.pro.java.course2.hw13;

import java.util.HashMap;
import java.util.Map;

public class Bouquet {
    private Map<Flower, Integer> bouquet;
    private double cost;
    private int lifeSpan = Integer.MAX_VALUE;
    private boolean isChanged;
    private String str;

    public Bouquet() {
        bouquet = new HashMap<>();
        isChanged = true;
    }

    public Bouquet(Map<Flower, Integer> bouquet) {
        this.bouquet = bouquet;
        isChanged = true;
    }

    public void addFlower(Flower flower) {
        addFlower(flower, 1);
        isChanged = true;
    }

    public void addFlower(Flower flower, int number) {
        if (bouquet.containsKey(flower)) {
            bouquet.put(flower, bouquet.get(flower) + number);
        } else {
            bouquet.put(flower, number);
        }
        isChanged = true;
    }

    public void addFlowers(Map<Flower, Integer> flowers) {
        for (Flower flower : flowers.keySet()) {
            addFlower(flower, flowers.get(flower));
        }
        isChanged = true;
    }

    private double roundCost(double cost) {
        return Math.floor(100 * cost) == Math.round(100 * cost) ? (double) Math.round(100 * cost) / 100 : Math.ceil(cost * 100) / 100;
    }

    public boolean removeFlower(Flower flower) {
        if (bouquet.remove(flower) != null) {
            isChanged = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeFlower(Flower flower, int number) {
        if (bouquet.containsKey(flower) && number < bouquet.get(flower)) {
            int currentNumber = bouquet.get(flower);
            if (number < currentNumber) {
                bouquet.put(flower, currentNumber - number);
            } else {
                removeFlower(flower);
            }
            isChanged = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (!isChanged) {
            return str;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Состав букета:\n");
            cost = 0;
            for (Flower flower : bouquet.keySet()) {
                int number = bouquet.get(flower);
                double total = roundCost(number * flower.getCost());
                stringBuilder.append(flower).append("\tX").append(number).append(" = ").append(String.format("%.2f", total)).append("RUB\n");
                cost += total;
                if (lifeSpan > flower.getLifeSpan()) {
                    lifeSpan = flower.getLifeSpan();
                }
            }
            double serviceFee = roundCost(0.1 * cost);
            stringBuilder.append("Работа флориста: ").append(String.format("%.2f", serviceFee)).append("RUB\n");
            cost = roundCost(serviceFee + cost);
            stringBuilder.append("Итого: ").append(String.format("%.2f", cost)).append("RUB. Простоит дней: ").append(lifeSpan);
            str = stringBuilder.toString();
            isChanged = false;
            return str;
        }
    }
}
