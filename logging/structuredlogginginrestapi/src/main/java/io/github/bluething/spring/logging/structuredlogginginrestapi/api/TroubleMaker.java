package io.github.bluething.spring.logging.structuredlogginginrestapi.api;

import org.springframework.stereotype.Service;

@Service
public class TroubleMaker {

    public String doSomethingBad() throws Exception {
        throw new Exception("I'm a bad guy");
    }

}
