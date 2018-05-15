package com.starvation;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static ReentrantLock lock = new ReentrantLock(true); // El parametro en true indica que sera un fair lock
                                                                        // los fair locks siguen la estructura first come first served para adquirir el lock
                                                                    // al implementar los fair lock el performace se ve impactado


    public static void main(String[] args) {

        // Starvation usando synchronized

        Thread thread1 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 10" );
        Thread thread2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8" );
        Thread thread3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6" );
        Thread thread4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4" );
        Thread thread5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2" );

        thread1.setPriority(10);
        thread2.setPriority(8);
        thread3.setPriority(6);
        thread4.setPriority(4);
        thread5.setPriority(2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();

            System.out.println("Todos los hilos sincronizados han terminado");
        }catch (InterruptedException e) {
        }

        System.out.println();
        System.out.println("Empiezan los hilos con Fair Locks");

        // solucion a starvation usando fair lock, afecta performance

        Thread threadFair1 = new Thread(new WorkerFairLock(ThreadColor.ANSI_PURPLE), "Priority 10" );
        Thread threadFair2 = new Thread(new WorkerFairLock(ThreadColor.ANSI_BLUE), "Priority 8" );
        Thread threadFair3 = new Thread(new WorkerFairLock(ThreadColor.ANSI_GREEN), "Priority 6" );
        Thread threadFair4 = new Thread(new WorkerFairLock(ThreadColor.ANSI_CYAN), "Priority 4" );
        Thread threadFair5 = new Thread(new WorkerFairLock(ThreadColor.ANSI_PURPLE), "Priority 2" );

        threadFair1.setPriority(10);
        threadFair2.setPriority(8);
        threadFair3.setPriority(6);
        threadFair4.setPriority(4);
        threadFair5.setPriority(2);

        threadFair1.start();
        threadFair2.start();
        threadFair3.start();
        threadFair4.start();
        threadFair5.start();




    }

    private static class Worker implements Runnable {
        private int runCount = 0;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }
        @Override
        public void run() {
            for(int i = 0; i< 100; i++) {
                synchronized (lock){
                System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                // execute critical section of code
            }
         }
        }
    }


    private static class WorkerFairLock implements Runnable {
        private int runCount = 0;
        private String threadColor;

        public WorkerFairLock(String threadColor) {
            this.threadColor = threadColor;
        }
        @Override
        public void run() {
            for(int i = 0; i< 100; i++) {
               lock.lock();
               try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
                } finally {
                   lock.unlock();
               }
            }
            }
        }
    }

