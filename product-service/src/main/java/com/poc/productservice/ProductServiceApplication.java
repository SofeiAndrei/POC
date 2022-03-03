package com.poc.productservice;

import com.poc.productservice.model.Product;
import com.poc.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(ProductRepository productRepository){
		return args -> {
			Product product = new Product("Sneakers","Adidas","Shoes","Good shoes, would buy again",9,99.99,39);
			productRepository.insert(product);
		};
	}

}
