package com.example.demo;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/v1/")
public class CiaoController {

    @RequestMapping(method = RequestMethod.GET, path = "ciao")
    public User ciao(@RequestParam String nome, @RequestParam String provincia) {
        User user = new User("Giuseppe", "Lombardia", "Ciao Giuseppe, com'è il tempo in Lombardia?");
        return user;
    }
}
