package io.github.bluething.spring.logging.restwithdistributedtracing.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Router {

    private final Logger logger = LoggerFactory.getLogger(Router.class);

    @GetMapping(path = "/book")
    public String getBook() {
        logger.info("enter getBook");
        return "Clean Code";
    }
}
