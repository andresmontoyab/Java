package com.read_writer;

public class Main {

    public static void main(String[] arg) {
        Message message = new Message();
        new Thread(new Writter(message)).start();
        new Thread(new Readder(message)).start();

    }
}
