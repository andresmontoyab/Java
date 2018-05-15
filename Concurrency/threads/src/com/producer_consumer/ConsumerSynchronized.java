package com.producer_consumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerSynchronized implements Runnable{
    private List<String> buffer;
    private String color;

    private static final String EOF = "EOF";

    public ConsumerSynchronized(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {
           synchronized (buffer) {
               if (buffer.isEmpty()) {
                   continue;
               }
               if (buffer.get(0).equals(EOF)) {
                   System.out.println(color + "Exiting ");
                   break;
               } else {
                   System.out.println(color + "Removed " + buffer.remove(0));
               }
           }
        }
    }
}
