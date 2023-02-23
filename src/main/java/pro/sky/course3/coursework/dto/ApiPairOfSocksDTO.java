package pro.sky.course3.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApiPairOfSocksDTO {
    private String color;
    private Integer size;
    private Integer cottonPart;
    private Integer quantity;
}
