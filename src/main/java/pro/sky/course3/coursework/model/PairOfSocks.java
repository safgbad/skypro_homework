package pro.sky.course3.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import pro.sky.course3.coursework.model.enums.Color;
import pro.sky.course3.coursework.model.enums.Size;

@Data
@AllArgsConstructor
public class PairOfSocks {
    private Color color;
    private Size size;
    private int cottonPart;
}
