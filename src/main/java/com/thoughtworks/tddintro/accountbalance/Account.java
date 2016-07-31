package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by laurakingsley on 7/30/16.
 */
public class Account {
    private int balance;
    public Account(int i) {
        balance = i;
    }

    public void deposit(int depositAmount) {
         balance += depositAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int withdrawAmount) {
        balance -= withdrawAmount;
    }
}
