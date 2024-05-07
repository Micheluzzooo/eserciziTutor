package com.example.deploy01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/devName")
public class BasicController {

    @GetMapping("")
    public String getDevName() {
        return "Michele";
    }
}
