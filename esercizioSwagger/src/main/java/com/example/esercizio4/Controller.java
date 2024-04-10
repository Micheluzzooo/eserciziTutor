package com.example.esercizio4;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/getName")
    public String getName(@RequestParam String name) {
        return name;
    }

    @PostMapping("/reverseName")
    public String reverseName(@RequestParam String name) {
        StringBuilder reversedName = new StringBuilder(name);
        return reversedName.reverse().toString();
    }
}

