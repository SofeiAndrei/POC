package com.poc.productservice.controller;

import com.poc.productservice.model.Product;
import com.poc.productservice.repository.ProductRepository;
import com.poc.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")//path to get to this controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
