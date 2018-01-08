package com.epam.jf.common.classwork.lesson23.deadlock;

public class Operator extends Thread {
    private Account account1;
    private Account account2;

    public Operator(Account account1, Account account2) {
        this.account1 = account1;
        this.account2 = account2;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            operationDeposit(10);
        }
    }

    private void operationDeposit(int depositSum) {
        synchronized (account1) {
            System.out.println("Заблокирован первый счет.");
            synchronized (account2) {
                System.out.println("Заблокирован второй счет.");
                account1.deposit(depositSum);
                account2.withdraw(depositSum);
            }
        }
    }
}

