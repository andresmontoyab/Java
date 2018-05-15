package com.deadlock_methods;

public class Main {

    public static void main(String[] args) {

        PolitePerson jane = new PolitePerson("Jane");
        PolitePerson jhon = new PolitePerson("Jhon");



        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(jhon);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                jhon.sayHello(jane);
            }
        }).start();


    }

    static class PolitePerson {

        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!%n",this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!%n",this.name, person.getName());
        }
    }

}