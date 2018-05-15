package com.threads;

import static com.threads.ThreadColor.ANSI_PURPLE;


public class anotherThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(ANSI_PURPLE + "Another thread woke me up");
            return;
        }
        System.out.println(ANSI_PURPLE + "Five seconds and im awake..");
    }
}
