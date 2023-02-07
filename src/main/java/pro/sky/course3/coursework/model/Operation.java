package pro.sky.course3.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import pro.sky.course3.coursework.model.enums.OperationType;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Operation {
    private Integer id;
    private OperationType operationType;
    private LocalDateTime dateTime;
    private PairOfSocks socks;
    private Integer quantity;
}
