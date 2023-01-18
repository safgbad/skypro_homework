package pro.sky.course3.hw24.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
@Setter
@ToString
public class Ingredient {

    private static int counter = 0;

    private Integer id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient ingredient = (Ingredient) o;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(name, ingredient.name)
                .append(amount, ingredient.amount)
                .append(measureUnit, ingredient.measureUnit);

        return eb.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hb = new HashCodeBuilder();
        hb.append(name)
                .append(amount)
                .append(measureUnit);

        return hb.toHashCode();
    }
}
