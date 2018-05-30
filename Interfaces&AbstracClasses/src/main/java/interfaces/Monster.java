package interfaces;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {

    private String name;
    private int hitPoints;
    private int strenght;

    public Monster(String name, int hitPoints, int strenght) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strenght = strenght;
    }

    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0 , this.name);
        values.add(1 , "" + this.hitPoints);
        values.add(2 , "" +this.strenght);

        return values;
    }

    public void read(List<String> savedValues) {
        if (savedValues != null && savedValues.size() > 0 ) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strenght = Integer.parseInt(savedValues.get(2));
        }

    }

    @Override
    public String toString() {
        return "Monster " + this.name + ", hitPoints " + this.hitPoints + " and Strengh " + this.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }
}
