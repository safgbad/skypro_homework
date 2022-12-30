package pro.sky.course3.hw23.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/info")
public class InfoController {
    @GetMapping("/student")
    public String getStudent() {
        return "Artem Nazarov";
    }

    @GetMapping("/name")
    public String getName() {
        return "SkyProHomework";
    }

    @GetMapping("/date")
    public LocalDate getDate() {
        return LocalDate.of(2022, 12, 29);
    }

    @GetMapping("/description")
    public String getDescription() {
        return "This project contains all the homework I've completed during period of study";
    }
}
