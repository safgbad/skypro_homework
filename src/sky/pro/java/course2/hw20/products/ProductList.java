package sky.pro.java.course2.hw20.products;

import sky.pro.java.utility.ValueCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductList {
    private final List<Product> productList;

    public ProductList() {
        productList = new ArrayList<>();
    }

    public void addProduct(String name, Double price, Double neededWeight) {
        if (!ValueCheck.isStringNotNullAndNotBlank(name)) {
            throw new NullPointerException("Название должно быть заполнено!");
        }
        if (!ValueCheck.isStringRussian(name)) {
            throw new IllegalArgumentException("Название должно быть на русском языке!");
        }
        if (price == null) {
            throw new NullPointerException("Цена должна быть заполнена!");
        }
        if (neededWeight == null) {
            throw new NullPointerException("Необходимое количество должно быть указано!");
        }
        Product product = new Product(name, price ,neededWeight);
        if (productList.contains(product)) {
            throw new IllegalArgumentException("Продукт \"" + name + "\" уже находится в списке!");
        }
        productList.add(product);
    }

    public boolean removeProduct(String product) {
        return productList.remove(new Product(product, null, null));
    }

    public boolean markProductAsBought(String product) {
        int index = productList.indexOf(new Product(product, null, null));
        if (index >= 0) {
            productList.get(index).setBought(true);
            return true;
        }
        return false;
    }

    public double sum() {
        double sum = 0.0;
        for (Product product : productList) {
            sum += product.getPrice() * product.getNeededWeight();
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
        for (Product product : productList) {
            stringBuilder.append("\n\t • ").append(product);
        }
        return stringBuilder.toString();
    }
}
