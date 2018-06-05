package SetChallenge;

import SetChallenge.ConcreteClasses.Moon;
import SetChallenge.ConcreteClasses.Planet;
import SetChallenge.ConcreteClasses.Star;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static Set<HeavenlyBoddy> solarSystem = new HashSet<>();

    public static void main(String[] args) {

        // The Sun
        Star sun = new Star("Solar System", 0.0);

        // Mercury
        Planet mercury = new Planet("Mercury", 0.1);

        // Venus
        Planet venus = new Planet("Venus", 0.2);

        // Earth
        Planet earth = new Planet("Earth", 1);
        Moon moon = new Moon("Moon", 0.23);
        Moon secondMoon = new Moon("Moon", 0.23);

        earth.addBody(moon);
        earth.addBody(secondMoon);

        // Mars
        Planet mars = new Planet("Mars", 0.4);
        Moon deimos = new Moon("Deimos", 0.041);
        Moon phobos = new Moon("Phobos", 0.041);
        mars.addBody(deimos);
        mars.addBody(phobos);

        //Jupiter
        Planet jupiter = new Planet("Jupiter", 0.5);
        Moon ganymede = new Moon("Ganymede", 0.051);
        Moon callisto = new Moon("Calisto", 0.052);
        Moon io = new Moon("Io", 0.053);
        Moon europa = new Moon("Europa", 0.054);
        jupiter.addBody(ganymede);
        jupiter.addBody(callisto);
        jupiter.addBody(io);
        jupiter.addBody(europa);

        //Saturn
        Planet saturn  = new Planet("Saturn", 0.6);
        Moon titan = new Moon("Titan", 0.061);
        Moon enceladus = new Moon("Enceladus", 0.062);
        saturn.addBody(titan);
        saturn.addBody(enceladus);

        // Uranus.
        Planet uranos = new Planet("Uranos", 0.7);
        Moon titania = new Moon("Titania", 0.071);
        Moon oberon = new Moon("Oberon", 0.072);
        Moon umbriel = new Moon("Umbriel", 0.073);
        Moon ariel = new Moon("Ariel", 0.074);
        Moon miranda= new Moon("Miranda", 0.075);
        uranos.addBody(titania);
        uranos.addBody(oberon);
        uranos.addBody(umbriel);
        uranos.addBody(ariel);
        uranos.addBody(miranda);

        // Neptune
        Planet neptune = new Planet("Neptune", 0.8);
        Moon triton = new Moon("Triton", 0.081);
        neptune.addBody(triton);

        // Adding planets to solar system

        Planet secondEarth = new Planet("Earth", 1);

        sun.addBody(mercury);
        sun.addBody(venus);
        sun.addBody(earth);
        sun.addBody(secondEarth);
        sun.addBody(mars);
        sun.addBody(jupiter);
        sun.addBody(saturn);
        sun.addBody(uranos);
        sun.addBody(neptune);

        Star secondSun = new Star("Solar System", 0.0);

        solarSystem.add(sun);
        solarSystem.add(secondSun);

        /// Finish prepare Data.

        System.out.println("Printing the whole solar system.");
        printWholeSolarSystem(solarSystem);

        // probing equals.

        System.out.println("Probing Equals");
        System.out.println("Equals the same sun");
        System.out.println(secondSun.equals(sun));
        System.out.println(sun.equals(secondSun));

        // Earth
        System.out.println("Equals the same Earth");
        System.out.println(secondEarth.equals(earth));
        System.out.println(earth.equals(secondEarth));

        System.out.println("Equals the same Moon");

        System.out.println(secondMoon.equals(moon));
        System.out.println(moon.equals(secondMoon));

        System.out.println("Adding values with the same equals");

    }

    public static void printWholeSolarSystem (Set<HeavenlyBoddy> solarsystem) {
        System.out.println("Whole universe");
        for (HeavenlyBoddy mainBody : solarsystem) {
            System.out.println("This is the " + mainBody.getName() + " " + mainBody.getBodyType());
            for (HeavenlyBoddy planet : mainBody.getSatallities()) {
                System.out.print("   ->");
                System.out.println(planet.getName() + " " + planet.getBodyType());
                for (HeavenlyBoddy satellities : planet.getSatallities()) {
                    System.out.print("       ->");
                    System.out.println(satellities.getName() + " " + satellities.getBodyType());
                }
            }
        }
    }
}
