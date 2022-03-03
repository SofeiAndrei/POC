package com.poc.productservice.service;

import com.poc.productservice.model.Product;
import com.poc.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
