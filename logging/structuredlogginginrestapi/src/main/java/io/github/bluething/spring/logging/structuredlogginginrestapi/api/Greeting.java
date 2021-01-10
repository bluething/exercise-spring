package io.github.bluething.spring.logging.structuredlogginginrestapi.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

    private final Logger LOGGER = LoggerFactory.getLogger(Greeting.class);

    @GetMapping(path = "/hii")
    public String sayHii() {
        LOGGER.info("entering GET handler");
        return "Hiii";
    }

    @GetMapping(path = "/hiitrouble")
    public String callTroubleMaker() throws Exception {
        throw  new Exception("Ouch :(");
    }

}
