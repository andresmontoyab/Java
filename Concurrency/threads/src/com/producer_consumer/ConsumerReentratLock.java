package com.producer_consumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerReentratLock implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    private static final String EOF = "EOF";

    public ConsumerReentratLock(List<String> buffer, String color, ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock = reentrantLock;
    }

    public void run() {

        int counter = 0;

        while (true) {
           if (reentrantLock.tryLock()){
               try {
                   if (buffer.isEmpty()) {
                       continue;
                   }
                   System.out.println("The counter is --> "+ counter);
                   System.out.println("Hilos esperando el lock " +reentrantLock.getQueueLength());
                   counter = 0;
                   if (buffer.get(0).equals(EOF)) {
                       System.out.println(color + "Exiting");
                       break;
                   } else {
                       System.out.println(color + "Removed " + buffer.remove(0));
                   }
               } finally {
                   reentrantLock.unlock();
               }
           } else {// truLock valida si el lock esta disponible y retorna un boolean, en caso de que no podemos hacer algo más en el else
            counter ++;
           }
        }

    }
}
