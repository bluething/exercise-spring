package io.github.bluething.spring.logging.structuredlogginginrestapi.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

    @GetMapping(path = "/hii")
    public String sayHii() {
        return "Hii";
    }

}
