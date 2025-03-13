package com.ssaxel03.fruitvegetableshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssaxel03.fruitvegetableshop.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByType(String type);
}
