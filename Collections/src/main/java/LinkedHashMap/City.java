package LinkedHashMap;

public class City {
    private String name;
    private int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (null == obj) {
            return false;
        }

        City city = (City) obj;
        return this.getName().equals(((City) obj).getName());
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getPopulation();
    }

}
