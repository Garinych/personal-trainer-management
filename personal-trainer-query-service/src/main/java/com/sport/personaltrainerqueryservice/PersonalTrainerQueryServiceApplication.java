package com.sport.personaltrainerqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ AxonConfig.class })
public class PersonalTrainerQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalTrainerQueryServiceApplication.class, args);
	}

}
