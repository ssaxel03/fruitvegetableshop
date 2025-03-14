package com.ssaxel03.fruitvegetableshop.model;

public class Wallet {
    
    private float balance;

    public Wallet() {
        this.balance = 1000;
    }

    public float getBalance(){
        return this.balance;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public boolean withdraw(float amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
