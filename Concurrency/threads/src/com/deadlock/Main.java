package com.deadlock;

public class Main {

    public static Object lockOne = new Object();
    public static Object lockTwo = new Object();


    public static void main(String[] args) {
        new ThreadOne().start();
        new ThreadTwo().start();

    }

    private static class ThreadOne extends Thread{
        public void run() {
            synchronized (lockOne) {
                System.out.println("Thread One: Has Lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread One: Waiting for lock 2");
                synchronized (lockTwo) {
                    System.out.println("Thread One: has Lock 1 and Lock 2");
                }
                System.out.println("Thread One: Release Lock 2");
            }
            System.out.println("Thread One: Release Lock1");
        }
    }

    private static class ThreadTwo extends Thread{
        public void run() {
            synchronized (lockTwo) {
                System.out.println("Thread Two: Has Lock 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread Two: Waiting for lock 1");
                synchronized (lockOne) {
                    System.out.println("Thread Two: has Lock 1 and Lock 2");
                }
                System.out.println("Thread Two: Release Lock 1");
            }
            System.out.println("Thread Two: Release Lock 2");
        }
    }
}
