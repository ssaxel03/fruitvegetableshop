package com.ssaxel03.fruitvegetableshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ssaxel03.fruitvegetableshop.model.Product;
import com.ssaxel03.fruitvegetableshop.repository.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
