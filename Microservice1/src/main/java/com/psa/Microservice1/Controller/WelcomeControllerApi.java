package com.psa.Microservice1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControllerApi {
    @GetMapping("/message")
    public String getMessage() {
        return "welcome";
    }
}
