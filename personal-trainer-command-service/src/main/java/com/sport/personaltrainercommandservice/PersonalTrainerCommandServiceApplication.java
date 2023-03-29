package com.sport.personaltrainercommandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class PersonalTrainerCommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalTrainerCommandServiceApplication.class, args);
    }

}
