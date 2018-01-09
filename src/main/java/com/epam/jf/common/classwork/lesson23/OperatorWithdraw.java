package com.epam.jf.common.classwork.lesson23;

public class OperatorWithdraw extends Thread {
    private Account account;

    public OperatorWithdraw(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account) {
            for (int i = 0; i < 5; i++) {
                account.withdraw(50);
            }
        }
    }
}

