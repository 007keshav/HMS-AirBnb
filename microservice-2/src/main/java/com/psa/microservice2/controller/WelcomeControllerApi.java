package com.psa.microservice2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControllerApi {
    @GetMapping("/message")
    public String getMessage(){
        return "message this is the 2nd micro service";
    }
}
