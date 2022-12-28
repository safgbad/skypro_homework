package pro.sky.course2.hw20.products;

import pro.sky.utility.ValueCheck;

import java.util.*;

public class ProductList {
    private final Map<Product, Double> productList;

    public ProductList() {
        productList = new HashMap<>();
    }

    public void addProduct(String name, Double price, Double neededAmount, Boolean isWeighable) {
        if (!ValueCheck.isStringNotNullAndNotBlank(name)) {
            throw new NullPointerException("Название должно быть заполнено!");
        }
        if (!ValueCheck.isStringRussian(name)) {
            throw new IllegalArgumentException("Название должно быть на русском языке!");
        }
        if (price == null) {
            throw new NullPointerException("Цена должна быть заполнена!");
        }
        if (isWeighable == null) {
            throw new NullPointerException("Укажите единицу измерения продукта!");
        }
        Product product;
        product = new Product(name, price, Objects.requireNonNullElse(neededAmount, 1.0), isWeighable);
        if (productList.containsKey(product)) {
            throw new IllegalArgumentException("Продукт \"" + name + "\" уже находится в списке!");
        }
        productList.put(product, neededAmount);
    }

    public boolean removeProduct(String product) {
        return productList.remove(new Product(product, null, null, null)) != null;
    }

    public boolean markProductAsBought(String product) {
        Product targetProduct = null;
        for (Product obj : productList.keySet()) {
            if (obj.equals(new Product(product, null, null, null))) {
                targetProduct = obj;
            }
        }
        if (targetProduct != null) {
            targetProduct.setBought(true);
            return true;
        }
        return false;
    }

    public double sum() {
        double sum = 0.0;
        for (Product product : productList.keySet()) {
            sum += product.getPrice() * product.getNeededAmount();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductList that = (ProductList) o;
        return productList.equals(that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Список продуктов:");
        for (Product product : productList.keySet()) {
            stringBuilder.append("\n\t • ").append(product);
        }
        return stringBuilder.toString();
    }
}
