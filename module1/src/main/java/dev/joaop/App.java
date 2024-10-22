package dev.joaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        logger.info("App Started!");
        SpringApplication.run(App.class, args);
    }
}
