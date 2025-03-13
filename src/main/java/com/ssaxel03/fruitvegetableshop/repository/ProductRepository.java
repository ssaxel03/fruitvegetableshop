package com.ssaxel03.fruitvegetableshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssaxel03.fruitvegetableshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
