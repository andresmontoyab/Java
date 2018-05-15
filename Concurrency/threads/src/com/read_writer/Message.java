package com.read_writer;

public class Message {

    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while(empty) {
            try {
                wait();     // El hilo esperará hasta ser notificado
            } catch (InterruptedException e){
            }
        }
        empty = true;
        notifyAll();        // Notifica a todos los hilos para que continuen con su ejecucion.
        return message;
    }


    public synchronized void write(String message) {
        while(!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                }
            }
        empty = false;
        notifyAll();
        this.message = message;

    }
}
