package com.challenge1_6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance;
    private String accountNumber;
    private ReentrantLock reentrantLock;

    public BankAccount(int balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.reentrantLock = new ReentrantLock();
        System.out.println("A bank account with " + this.balance + " was created.");
        System.out.println("The balance is :" + this.balance);
        System.out.println("The account name is " + this.accountNumber);
    }

    public void deposit(int deposit, String threadName) {
        try {
            if(reentrantLock.tryLock(1000,TimeUnit.MILLISECONDS)) {
                try {
                    this.balance += deposit;
                    System.out.println("The thread called "+ threadName + " has deposit the amount of " +deposit);
                    System.out.println("The balance is :" + this.balance);
                } finally {
                    reentrantLock.unlock();
                }
            }
        }catch (InterruptedException e) {
            // do something
        }




    }

    public void withdraw(int withdraw, String threadName) {
        try {
            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    this.balance -= withdraw;
                    System.out.println("The thread called "+ threadName + " has withdraw the amount of " +withdraw);
                    System.out.println("The balance is :" + this.balance);
                } finally {
                    reentrantLock.unlock();
                }
            }
        } catch (InterruptedException e) {

        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public synchronized void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        System.out.println("The new accout number is "  + accountNumber);
    }

    public void updateBankAccount(String newNumberAccount) {
        this.setAccountNumber(newNumberAccount);
    }
}
