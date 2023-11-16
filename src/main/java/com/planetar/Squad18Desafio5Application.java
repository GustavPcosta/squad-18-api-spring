package com.planetar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan(basePackages = "com.planetar.model")
@SpringBootApplication
public class Squad18Desafio5Application {

	public static void main(String[] args) {
		SpringApplication.run(Squad18Desafio5Application.class, args);
	}

}
