package com.ssaxel03.fruitvegetableshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssaxel03.fruitvegetableshop.model.Wallet;
import com.ssaxel03.fruitvegetableshop.service.TransactionService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    
    private final TransactionService transactionService;

    public WalletController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<Wallet> getWallet() {
        return ResponseEntity.ok(transactionService.getWallet());
    }
}
