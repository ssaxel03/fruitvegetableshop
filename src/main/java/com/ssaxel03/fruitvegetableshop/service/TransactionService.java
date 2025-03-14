package com.ssaxel03.fruitvegetableshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ssaxel03.fruitvegetableshop.model.Product;
import com.ssaxel03.fruitvegetableshop.model.Transaction;
import com.ssaxel03.fruitvegetableshop.model.Wallet;
import com.ssaxel03.fruitvegetableshop.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final ProductService productService;

    private final Wallet wallet;

    public TransactionService(TransactionRepository transactionRepository, ProductService productService) {
        this.transactionRepository = transactionRepository;
        this.productService = productService;
        this.wallet = new Wallet();
    }

    public Transaction addTransaction(Transaction transaction) {
        
        if ("BUY".equals(transaction.getType().toString())) {

            Product productToBeBought = productService.getProductById(transaction.getProduct().getId()).orElse(null);

            if(productToBeBought == null) {
                throw new IllegalArgumentException();
            }

            transaction.setProduct(productToBeBought);

            this.wallet.deposit(transaction.getValue());
            return transactionRepository.save(transaction);
        }
    
        if ("SELL".equals(transaction.getType().toString())) {

            Product productToBeBought = productService.getProductById(transaction.getProduct().getId()).orElse(null);

            if(productToBeBought == null) {
                throw new IllegalArgumentException();
            }

            transaction.setProduct(productToBeBought);

            if (this.wallet.withdraw(transaction.getValue())) {
                return transactionRepository.save(transaction);
            } else {
                throw new IllegalArgumentException("Insufficient funds in wallet for SELL transaction");
            }
        }
    
        
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

    public Wallet getWallet() {
        return this.wallet;
    }
}
