package io.github.bluething.spring.logging.fundamental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentalApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(FundamentalApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Before start");
        SpringApplication.run(FundamentalApplication.class, args);
        LOGGER.info("After start");
        LOGGER.debug("Debugging mode");
    }

}
