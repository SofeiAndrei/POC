package com.poc.productservice.service.impl;

import com.poc.productservice.exception.NotFoundException;
import com.poc.productservice.model.Product;
import com.poc.productservice.repository.ProductRepository;
import com.poc.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
//        Optional<Product> product = productRepository.findById(id);
//        if(product.isPresent()){//if the product exists
//            return product.get();
//        }
//        else{
//            throw new NotFoundException("Product", "Id", id);
//        }
        //OR:
        return productRepository.findById(id).orElseThrow( ()->new NotFoundException("Product", "Id", id));
    }

    @Override
    public Product updateProduct(Product product, long id_to_change) {
        //we need to check if the product with the id exists
        Product existing_product = productRepository.findById(id_to_change).orElseThrow( ()->new NotFoundException("Product", "Id", id_to_change));
        existing_product.setName(product.getName());
        existing_product.setBrand(product.getBrand());
        existing_product.setCategory(product.getCategory());
        existing_product.setCategory(product.getCategory());
        existing_product.setDescription(product.getDescription());
        existing_product.setRating(product.getRating());
        existing_product.setPrice(product.getPrice());
        existing_product.setCountInStock(product.getCountInStock());
        productRepository.save(existing_product);
        return existing_product;
    }

    @Override
    public void deleteProduct(long id_to_delete) {
        productRepository.findById(id_to_delete).orElseThrow( ()->new NotFoundException("Product", "Id", id_to_delete));
        productRepository.deleteById(id_to_delete);
    }
}
