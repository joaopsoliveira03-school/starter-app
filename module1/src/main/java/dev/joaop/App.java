package dev.joaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        logger.info("App Started!");
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
//        return args -> {
//            logger.info("Inspecting Beans provided by Spring Boot:");
//            String[] beanNames = applicationContext.getBeanDefinitionNames();
//            for (String beanName : beanNames) {
//                logger.info(beanName);
//            }
//        };
//    }
}
