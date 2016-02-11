package com.example;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (ProductRepository productRepository) {
		return args -> {
			Arrays.asList("TV, Phone, PC, Tablet, Clock".split(",")).forEach(n -> productRepository.save(new Product(n)));
		};
	}
}
