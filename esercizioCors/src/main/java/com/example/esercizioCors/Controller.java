package com.example.esercizioCors;

import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:2020")
public class Controller {
    @RequestMapping(method = RequestMethod.GET, path = "/name")
    @PostMapping("/name")
    public String name(@RequestParam String name) {
        return name;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/reverse")
    @PostMapping("/reverse")

    public String reverse(@RequestBody String name) {
        return new StringBuilder(name).reverse().toString();
    }
}

