package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringBootJdbc1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbc1Application.class, args);
		System.out.println("cloninig this project");
	}

}
