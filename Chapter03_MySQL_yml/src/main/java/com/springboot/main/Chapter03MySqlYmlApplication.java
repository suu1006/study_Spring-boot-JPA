package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.main.*", "user.*"})
public class Chapter03MySqlYmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter03MySqlYmlApplication.class, args);
	}

}
