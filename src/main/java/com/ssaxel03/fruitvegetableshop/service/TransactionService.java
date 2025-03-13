package com.ssaxel03.fruitvegetableshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ssaxel03.fruitvegetableshop.model.Transaction;
import com.ssaxel03.fruitvegetableshop.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> getTransactionsByType(String type) {
        return transactionRepository.findByType(type);
    }
}
