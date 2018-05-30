package abstract_class;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Zoe");
        dog.breathe();
        dog.eat();

        Bird bird = new Parrot("Dher");
        bird.breathe();
        bird.eat();
        bird.fly();


        Bird penguin = new Penguin("Ostring");
        penguin.fly();
        penguin.eat();
        penguin.breathe();
    }
}
