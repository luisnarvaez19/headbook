package com.hiberus.headbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.hiberus.headbook.repository") 
@EntityScan("com.hiberus.headbook.model")
@SpringBootApplication
public class HeadbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeadbookApplication.class, args);
	}

}

