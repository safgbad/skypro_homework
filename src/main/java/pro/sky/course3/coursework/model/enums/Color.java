package pro.sky.course3.coursework.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    BLACK("black"),
    WHITE("white"),
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    PURPLE("purple"),
    YELLOW("yellow"),
    ORANGE("orange"),
    BROWN("brown"),
    LIGHTBLUE("lightblue"),
    PINK("pink"),
    GRAY("gray");

    private final String value;
}
