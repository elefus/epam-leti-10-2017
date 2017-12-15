package com.epam.jf.common.classwork.lesson23;

public class Account {

    private volatile int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {

        balance -= amount;
    }
}

// OperatorDeposit
// 200
// Load = 200
// Sum = 300
// Store -> 300

// OperatorWithdraw
// 150
// Load = 200
// Sub = 150
// Store -> 150