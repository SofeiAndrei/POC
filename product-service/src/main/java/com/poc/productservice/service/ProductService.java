package com.poc.productservice.service;

import com.poc.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Product product, long id_to_change);
    void deleteProduct(long id_to_delete);
}
