package com.read_writer;

import java.util.Random;

public class Readder implements Runnable {

    private Message message;

    public Readder(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        String latesMessage;
        for(latesMessage = message.read(); !latesMessage.equals("Finish"); latesMessage = message.read()){
            System.out.println(latesMessage);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e) {
                System.out.println("Error en el reader");
            }
        }




    }
}
