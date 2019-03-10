package app.kitesurfing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class grettingsController {

    @GetMapping("/start")
    public String getGrettingsMessage() {
        return "Welcome to Kite Surfing API ~ Popescu Andrei\n";
    }
}
