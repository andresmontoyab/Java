package Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, HeavenlyBoddy> solarSystem = new HashMap<>();
    private static Set<HeavenlyBoddy> planets  = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBoddy temp = new HeavenlyBoddy("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBoddy("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBoddy("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBoddy tempMoon = new HeavenlyBoddy("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);


        temp = new HeavenlyBoddy("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBoddy("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBoddy("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBoddy("Jupiter",     4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBoddy("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBoddy("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);


        tempMoon = new HeavenlyBoddy("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);


        tempMoon = new HeavenlyBoddy("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);


        System.out.println("Planets");


        for (HeavenlyBoddy planet : planets) {
            System.out.println(planet.getName());
        }

        Set<HeavenlyBoddy> moons = new HashSet<>();

        for (String planet : solarSystem.keySet()) {
            for (HeavenlyBoddy moon : solarSystem.get(planet).getSatallities()) {
                moons.add(moon);
            }
        }
        for (HeavenlyBoddy moon : moons) {
            System.out.println(moon.getName());
        }


    }
}
