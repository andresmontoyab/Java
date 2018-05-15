package com.multi.threads;

public class CountDown {

    private int i;


    public void doCountDown() {
        String color;
        int number;
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        synchronized (this) {
        for (i = 10; i>0; i--){
            System.out.println(color + Thread.currentThread().getName() + ": i = " +i);
        }
    }}



}
