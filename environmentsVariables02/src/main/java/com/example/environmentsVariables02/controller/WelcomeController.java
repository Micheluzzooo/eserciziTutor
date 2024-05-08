package com.example.environmentsVariables02.controller;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ConfigurationProperties
@Profile("prod")
@RestController
@RequestMapping
public class WelcomeController {

    private String welcomeMsg;

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return welcomeMsg;
    }
}
