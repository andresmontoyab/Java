package com.multi.threads;

public class Main {

    public static void main(String[] args) {
        CountDown countDown = new CountDown();
        CountDownThread thread1 = new CountDownThread(countDown);
        thread1.setName("Thread 1");

        CountDownThread thread2 = new CountDownThread(countDown);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}
