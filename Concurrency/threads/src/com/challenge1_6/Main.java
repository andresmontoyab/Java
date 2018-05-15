package com.challenge1_6;

public class Main {

    private static final BankAccount bankAccount = new BankAccount(100, "101010");

    public static void main(String[] arg) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(100, "Thread 1");
                bankAccount.withdraw(50, "Thread 1");
                bankAccount.updateBankAccount("151515");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(200, "Thread 2");
                bankAccount.withdraw(100, "Thread 2");
            }
        }).start();
    }
}
