package com.example.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloworldController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/manoj")
    public String callManoj(){
        return "Hello Manoj!";
    }
}
