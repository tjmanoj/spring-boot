package com.example.datefinder;
import java.time.*;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyController {
    @GetMapping("/")
    public String addDays(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.now().plusDays(100);
        return formatter.format(date);
    }

}
