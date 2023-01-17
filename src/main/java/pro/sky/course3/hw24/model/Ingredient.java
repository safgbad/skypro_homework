package pro.sky.course3.hw24.model;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

import static pro.sky.utility.ValueCheck.*;

@Data
@Getter
public class Ingredient {
    private static final String DEFAULT_NAME = "<INGREDIENT_NAME>";
    private static final int DEFAULT_AMOUNT = 1;
    private static final String DEFAULT_MEASURE_UNIT = "г";

    private static int counter = 0;

    private final Integer id;
    private String name;
    private Integer amount;
    private String measureUnit;

    public Ingredient(String name,
                      Integer amount,
                      String measureUnit) {
        id = ++counter;
        setName(name);
        setAmount(amount);
        setMeasureUnit(measureUnit);
    }

    public void setName(String name) {
        if (isStringNotNullAndNotBlank(name)) {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME;
        }
    }

    public void setAmount(Integer amount) {
        if (isNumberNotNullAndPositive(amount)) {
            this.amount = amount;
        } else {
            this.amount = 1;
        }
    }

    public void setMeasureUnit(String measureUnit) {
        if (isStringNotNullAndNotBlank(measureUnit)) {
            this.measureUnit = measureUnit;
        } else {
            this.measureUnit = DEFAULT_MEASURE_UNIT;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;

        return Objects.equals(name, that.name)
                && Objects.equals(amount, that.amount)
                && Objects.equals(measureUnit, that.measureUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, measureUnit);
    }
}
