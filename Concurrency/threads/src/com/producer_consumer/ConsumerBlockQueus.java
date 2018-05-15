package com.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerBlockQueus implements Runnable{
    private ArrayBlockingQueue buffer;
    private String color;

    private static final String EOF = "EOF";

    public ConsumerBlockQueus(ArrayBlockingQueue buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {

        while (true) {
            synchronized (buffer) {     // Se debe utilizar la sincronizacion debido a que se estaban generacion null pointer exp
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                }
            }
        }
        }

    }

