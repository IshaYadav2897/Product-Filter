package com.flipkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FlipkartAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipkartAppApplication.class, args);
	}

}
