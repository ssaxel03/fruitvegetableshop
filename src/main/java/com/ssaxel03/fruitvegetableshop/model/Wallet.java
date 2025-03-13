package com.ssaxel03.fruitvegetableshop.model;

public class Wallet {
    
    private float balance;

    public float getBalance(){
        return this.balance;
    }

    public void deposit(float depositValue) {
        this.balance += depositValue;
    }

    public void withdraw(float withdrawValue) {
        this.balance -= withdrawValue;
    }

}
