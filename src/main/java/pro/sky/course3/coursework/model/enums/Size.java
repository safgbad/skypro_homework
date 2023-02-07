package pro.sky.course3.coursework.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pro.sky.course3.coursework.exceptions.InvalidInputException;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Size {
    RU18_19(18, 19),
    RU20_22(20, 22),
    RU23_26(23, 26),
    RU27_28(27, 28),
    RU29_31(29, 31),
    RU32_34(32, 34),
    RU35_38(35, 38),
    RU39_40(39, 40),
    RU41_42(41, 42),
    RU43_44(43, 44),
    RU45_46(45, 46),
    RU46_48(46, 48);

    private final int lowerSize;
    private final int upperSize;

    public static Size getSize(Integer num) throws InvalidInputException {
        if (num == null) {
            throw new InvalidInputException("Size is not specified");
        }

        return Arrays.stream(Size.values())
                .filter(size -> num <= size.upperSize && num >= size.lowerSize)
                .findFirst()
                .orElseThrow(() -> new InvalidInputException("This size (" + num + ") " +
                        "is not available in the store"));
    }
}
