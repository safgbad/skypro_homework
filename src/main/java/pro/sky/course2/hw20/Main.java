package pro.sky.course2.hw20;

import pro.sky.course2.hw20.passports.Passport;
import pro.sky.course2.hw20.passports.PassportDatabase;
import pro.sky.course2.hw20.products.ProductList;
import pro.sky.course2.hw20.products.Recipe;
import pro.sky.course2.hw20.products.RecipeBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Receipts
        ProductList productList = new ProductList();
        productList.addProduct("Яблоки", 59.90, 1.2, true);
        productList.addProduct("Ветчина", 639.90, 0.4, true);
        productList.addProduct("Хлеб", 45.90, 0.6, true);
        productList.removeProduct("Яблоки");
        productList.markProductAsBought("Колбаса докторская");
        RecipeBook recipeBook = new RecipeBook();
        recipeBook.addReceipt(new Recipe("Сэндвич с ветчиной", productList));
        recipeBook.addReceipt(new Recipe("Сэндвич с курицей"));
        recipeBook.getReceipt("Сэндвич с курицей").addIngredient("Хлеб", 45.90, 0.6, true);
        recipeBook.getReceipt("Сэндвич с курицей").addIngredient("Курица", 350.0, 0.4, true);
        System.out.println(recipeBook);
//        receiptBook.addReceipt(new Receipt("Сэндвич с курицей")); // throw
        
        // numbers
        List<Integer> numbers = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            numbers.add((int) (1001 * Math.random()));
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        int index = 0;
        while (index < numbers.size()) {
            if (numbers.get(index) % 2 == 1) {
                numbers.remove(index);
                continue;
            }
            index++;
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("========================================");

        // multiplication table
        Set<String> tasks = new HashSet<>();
        while (tasks.size() < 15) {
            int firstNumber = (int) (2 + 8 * Math.random());
            int secondNumber = (int) (2 + 8 * Math.random());
            if (!tasks.contains(String.format("%d * %d =", secondNumber, firstNumber))) {
                tasks.add(String.format("%d * %d =", firstNumber, secondNumber));
            }
        }
        for (String task : tasks) {
            System.out.println(task);
        }

        System.out.println();
        System.out.println("========================================");

        // passports
        PassportDatabase passportDatabase = new PassportDatabase();
        passportDatabase.addPassport(new Passport(
                "4814 149123",
                "Ivanov",
                "Ivan",
                LocalDate.of(1984, 12, 5)));
        System.out.println(passportDatabase.getPassport("4814 149123"));
        passportDatabase.addPassport(new Passport(
                "4814 149123",
                "Ivanov",
                "Ivan",
                "Ivanovich",
                LocalDate.of(1984, 12, 5)));
        System.out.println(passportDatabase.getPassport("4814 149123"));
        passportDatabase.addPassport(new Passport(
                "1234 567890",
                "Andreev",
                "Andrey",
                "Andreevich",
                LocalDate.of(1975, 5, 24)));
        System.out.println(passportDatabase.getPassport("1234 567890"));
    }
}
