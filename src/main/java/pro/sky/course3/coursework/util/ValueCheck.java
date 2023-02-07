package pro.sky.course3.coursework.util;

import pro.sky.course3.coursework.exceptions.InvalidInputException;

public class ValueCheck {
    public static void checkCottonPart(Integer cottonPart, boolean acceptNulls) throws InvalidInputException {
        if (cottonPart == null && !acceptNulls) {
            throw new InvalidInputException("Cotton part is not specified");
        }
        if (cottonPart != null && (cottonPart < 0 || cottonPart > 100)) {
            throw new InvalidInputException("Cotton part should belong to interval [0; 100]. " +
                    "Specified value is " + cottonPart);
        }
    }

    public static void checkQuantity(Integer quantity) throws InvalidInputException {
        if (quantity == null) {
            throw new InvalidInputException("Quantity is not specified");
        }
        if (quantity <= 0) {
            throw new InvalidInputException("Quantity should be positive number. " +
                    "Specified value is " + quantity);
        }
    }
}
