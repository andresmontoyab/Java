package com.threads;

import static com.threads.ThreadColor.ANSI_CYAN;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "Hello from my runnable implementation of run()");
    }
}
