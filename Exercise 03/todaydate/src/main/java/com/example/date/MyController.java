package com.example.date;
import java.time.*;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyController {
    
    @GetMapping("/")
    public String printDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.now();
        return formatter.format(date);
    }
}
