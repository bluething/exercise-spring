package io.github.bluething.spring.logging.structuredlogginginrestapi.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

    private final Logger LOGGER = LoggerFactory.getLogger(Greeting.class);

    private final TroubleMaker troubleMaker;

    @Autowired
    public Greeting(TroubleMaker troubleMaker) {
        this.troubleMaker = troubleMaker;
    }

    @GetMapping(path = "/hii")
    public String sayHii() {
        LOGGER.info("entering GET handler");
        return "Hiii";
    }

    @GetMapping(path = "/hiitrouble")
    public String callTroubleMaker() throws Exception {
        return troubleMaker.doSomethingBad();
    }

    @GetMapping(path = "/makeownfault")
    public String makeOwnFault() throws Exception {
        throw new Exception("Ouch :(");
    }

}
