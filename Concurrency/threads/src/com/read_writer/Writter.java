package com.read_writer;

import java.util.Random;

public class Writter implements Runnable {

    private Message message;

    public Writter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String message[] = {
                "Humpty dumpty sat on a wall",
                "Humpy dumpty had a great fall",
                "all king's hosrses and all the king's men",
                "Couldn't put humpty together again"
        };

        Random random = new Random();

        for (int i = 0; i< message.length; i++) {
            this.message.write(message[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e) {
            }
        }
        this.message.write("Finish");
    }
}
