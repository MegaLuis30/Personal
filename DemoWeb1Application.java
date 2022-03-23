package com.mitocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class DemoWeb1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoWeb1Application.class, args);
	}

}
