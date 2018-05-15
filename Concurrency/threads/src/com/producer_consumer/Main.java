package com.producer_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] arg) {

        ReentrantLock reentrantLock = new ReentrantLock(); // este lock controlará todos los thread, si alguno de los
                                                            // hilos tiene lock(), los otros no podran seguir, hasta que
                                                            // el hilo realice el respectivo unlock().

        /**
         * El uso adecuado de los Lock, deberá utilizarse con un finally statment, esto con el objetivo
         * de que si en alguna circunstancia se produce una excepcion no controlada podamos liberar
         * todos los locks.
         */

        List<String> bufferReentrantLock = new ArrayList<String>();
        ProducerReentratLock producerReentratLock = new ProducerReentratLock(bufferReentrantLock, ThreadColor.ANSI_RED, reentrantLock);
        ConsumerReentratLock consumerReentratLock1 = new ConsumerReentratLock(bufferReentrantLock, ThreadColor.ANSI_PURPLE, reentrantLock);
        ConsumerReentratLock consumerReentratLock2 = new ConsumerReentratLock(bufferReentrantLock, ThreadColor.ANSI_CYAN, reentrantLock);

        Thread producerLock = new Thread(producerReentratLock);
        producerLock.start();

        Thread consumerLock1 = new Thread(consumerReentratLock1);
        consumerLock1.start();

        Thread consumerLock2 = new Thread(consumerReentratLock2);
        consumerLock2.start();

        try {
            producerLock.join();
            consumerLock1.join();
            consumerLock2.join();
            System.out.println("Los hilos de Reentrant lock han termiando, se procede con Synchronized");
        }catch (InterruptedException e) {
        }

        /// synchronized


        List<String> bufferSynchronized = new ArrayList<String>();
        ProducerSynchronized producerSynchronized = new ProducerSynchronized(bufferSynchronized, ThreadColor.ANSI_RED);
        ConsumerSynchronized consumerSynchronized1 = new ConsumerSynchronized(bufferSynchronized, ThreadColor.ANSI_BLUE);
        ConsumerSynchronized consumerSynchronized2 = new ConsumerSynchronized(bufferSynchronized, ThreadColor.ANSI_BLACK);

        Thread producerSynchronizedThread = new Thread(producerSynchronized);
        producerSynchronizedThread.start();

        Thread consumerSynchronizedThreadUno = new Thread(consumerSynchronized1);
        consumerSynchronizedThreadUno.start();

        Thread consumerSynchronizedThreadDos = new Thread(consumerSynchronized2);
        consumerSynchronizedThreadDos.start();

        try {
            producerSynchronizedThread.join();
            consumerSynchronizedThreadUno.join();
            consumerSynchronizedThreadDos.join();
            System.out.println("Los hilos de Reentrant lock han termiando, se procede con Synchronized");
        }catch (InterruptedException e) {
        }


        System.out.println("Ha terminado la ejecucion del os hilos syncronizados, procedemos con el ejecutor.");
        // Using Executor

        ArrayBlockingQueue bufferQueu = new ArrayBlockingQueue(6);

        ExecutorService executorService  = Executors.newFixedThreadPool(3); // El ejecutor maneja adecuadamente la ejecucion de una cantidad de hilos

        ProducerBlockQueus producerBlockQueus = new ProducerBlockQueus(bufferQueu, ThreadColor.ANSI_RED);
        ConsumerBlockQueus consumerBlockQueusOne  = new ConsumerBlockQueus(bufferQueu, ThreadColor.ANSI_BLUE);
        ConsumerBlockQueus consumerBlockQueusTwo = new ConsumerBlockQueus(bufferQueu, ThreadColor.ANSI_BLACK);

        executorService.execute(producerBlockQueus);
        executorService.execute(consumerBlockQueusOne);
        executorService.execute(consumerBlockQueusTwo);

        Future<String> future = executorService.submit(new Callable<String>() { // Future son utilizados para esperar la respuesta de un thread
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_RESET + " Im being pritned for the callable clase");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());       // future.get() block until the resource is available
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interupted.");
        }

        executorService.shutdown();

    }
}
