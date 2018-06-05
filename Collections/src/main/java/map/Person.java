package map;

public class Person {
    private String name;
    private int numberId;

    public Person(String name, int numberId) {
        this.name = name;
        this.numberId = numberId;
    }

    public String getName() {
        return name;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
