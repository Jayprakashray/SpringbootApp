package com.test.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.test.java.repo.TransDetailsRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = TransDetailsRepository.class)
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

}
