package com.example.cricketseries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CricketseriesApplication {

    private static final Logger logger = LoggerFactory.getLogger(CricketseriesApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Cricket Series Application...");
        SpringApplication.run(CricketseriesApplication.class, args);
        logger.info("Cricket Series Application Started Successfully.");
    }
}
