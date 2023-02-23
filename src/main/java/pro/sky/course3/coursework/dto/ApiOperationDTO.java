package pro.sky.course3.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiOperationDTO {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private Integer id;
    private String operationType;
    private String dateTime;
    private ApiPairOfSocksDTO socks;
}
