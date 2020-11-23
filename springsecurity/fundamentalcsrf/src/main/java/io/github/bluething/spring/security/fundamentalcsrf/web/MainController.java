package io.github.bluething.spring.security.fundamentalcsrf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping
    public String main() {
        return "main.html";
    }

    // POST, PUT, DELETE mutating actions in REST
    @PostMapping("/change")
    public String doSomething() {
        System.out.println(":(");
        return "main.html";
    }
}
