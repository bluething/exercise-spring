package io.github.bluething.spring.security.fundamentalcsrf.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping
    public String main() {
        return "main.html";
    }
}
