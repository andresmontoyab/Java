package com.producer_consumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerSynchronized implements Runnable {
    private List<String> buffer;
    private String color;

    private static final String EOF = "EOF";

    public ProducerSynchronized(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1","2","3","4","5"};

        for(String num : nums) {
            try {
                System.out.println(color + "Adding...." + num);
                synchronized (buffer) {
                    buffer.add(num);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(color + "ProducerSynchronized was interrupted.");
            }
        }
        System.out.println(color +"Adding EOF and exiting ....");
        synchronized (buffer) {
            buffer.add(EOF);
        }
    }
}
