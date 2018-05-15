package com.livelocks;

public class Main {

    public static void main( String[] args) {
        final Worker workerJuan = new Worker("Juan", true);
        final Worker workerCarlos = new Worker("Carlos", true);

        final SharedResource sharedResource = new SharedResource(workerJuan);

        new Thread(new Runnable() {
            @Override
            public void run() {
                workerJuan.work(sharedResource, workerCarlos);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                workerCarlos.work(sharedResource, workerJuan);
            }
        }).start();
    }
}
