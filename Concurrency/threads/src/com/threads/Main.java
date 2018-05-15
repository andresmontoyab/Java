package com.threads;

import static com.threads.ThreadColor.ANSI_RED;
import static com.threads.ThreadColor.ANSI_GREEN;
import static com.threads.ThreadColor.ANSI_RESET;

/*
Notas importantes

Cuando estemos usando com.threads es importante siempre usar la funcion start() en vez de run(), si usamos run
nuestro hilo se ejecutará en el hilo desde donde se llamar, cuando se usa start se creará adecuadamente el nuevo hilo.
* */

public class Main {

    public static void main(String[] args){
        System.out.println(ANSI_RED +"Hello from the main thread.");

        // generacion de clase que extienda de thread.
        anotherThread anotherThread = new anotherThread();
        anotherThread.start();


        // clase anonima
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class ");
            }
        }.start();


        // runnable
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                //action
            }
        }).start();


        // runnable anonimo
        Thread myRunnableAnonymous = new Thread(new MyRunnable() {
            @Override
            public void run(){
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RESET + "Another thread terminated or time out, so im running again.");
                }catch (InterruptedException e){
                    System.out.println(ANSI_RESET + "I couldnt wait after all. I was interrupted.");
                    return;
                }
                System.out.println(ANSI_RESET + "Hello from runnable implementation anonymous");
            }
        });

        myRunnableAnonymous.start();
        //anotherThread.interrupt();

        System.out.println(ANSI_RED +"Hello again from the main thread");
    }
}
