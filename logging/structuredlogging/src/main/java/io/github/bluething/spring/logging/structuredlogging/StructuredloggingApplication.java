package io.github.bluething.spring.logging.structuredlogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StructuredloggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(StructuredloggingApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Logger logger = LoggerFactory.getLogger(StructuredloggingApplication.class);

        logger.info("Hello World!");

        try {
            throw new NullPointerException("Is Null");
        } catch (NullPointerException nEx) {
            logger.error("I show when level is ERROR", nEx);
        }
    }

}
