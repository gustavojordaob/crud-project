package com.example.CrudProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CrudProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudProjectApplication.class, args);
	}

}
