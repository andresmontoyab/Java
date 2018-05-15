package com.producer_consumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerReentratLock implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    private static final String EOF = "EOF";

    public ProducerReentratLock(List<String> buffer, String color, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};

        for(String num : nums) {
            try {
                System.out.println(color + "Adding...." + num);
                reentrantLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    reentrantLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(color + "ProducerReentratLock was interrupted.");
            }
        }
        System.out.println(color +"Adding EOF and exiting ....");
        reentrantLock.lock();
        try {
            buffer.add(EOF);
        } finally {
            reentrantLock.unlock();
        }
    }
}
