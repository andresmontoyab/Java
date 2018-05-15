package com.multi.threads;

public class CountDownThread extends Thread{
    private CountDown threadCountDown;

    public CountDownThread(CountDown threadCountDown) {
        this.threadCountDown = threadCountDown;
    }

    public void run() {
        threadCountDown.doCountDown();
    }
}
