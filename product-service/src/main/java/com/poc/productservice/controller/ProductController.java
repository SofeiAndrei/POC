package com.poc.productservice.controller;

import com.poc.productservice.model.Product;
import com.poc.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }
    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable(name = "id") Long id_to_change){
        return new ResponseEntity<Product>(productService.updateProduct(product, id_to_change), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "id")Long id_to_delete){
        productService.deleteProduct(id_to_delete);
        return new ResponseEntity<String>("Product deleted successfully!", HttpStatus.OK);
    }
}
