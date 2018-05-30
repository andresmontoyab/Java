package abstract_class;

public class Parrot extends Bird {

    public Parrot(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(getName() + " is flying");
    }
}
