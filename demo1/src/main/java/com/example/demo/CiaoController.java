package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/v1/")
public class CiaoController {

    @RequestMapping(method = RequestMethod.GET, path = "ciao/{provincia}")
    public User ciao(@RequestParam String nome, @PathVariable("provincia") String provincia, @RequestParam String date) {
        String saluto = "ciao " + nome + " com'è il tempo a/in " + provincia + "?";
        User user = new User(nome, provincia, saluto, convertStringToDate(date));
        return user;

    }

    private OffsetDateTime convertStringToDate(String date) {
        try {
            OffsetDateTime date1 = OffsetDateTime.parse(date);
            return date1;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
