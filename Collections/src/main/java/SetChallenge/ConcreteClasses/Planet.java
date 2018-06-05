package SetChallenge.ConcreteClasses;

import SetChallenge.HeavenlyBoddy;
import SetChallenge.TypesHeavenlyBody;

public class Planet extends HeavenlyBoddy {

    public Planet(String name, double orbintalPeriod) {
        super(name, orbintalPeriod, TypesHeavenlyBody.PLANET);
    }

    @Override
    public boolean addBody(HeavenlyBoddy moon) {
        if (moon.getBodyType().toString().equals(TypesHeavenlyBody.MOON.toString())) {
            super.addBody(moon);
            return true;
        } else {
            System.out.println("Only moons can be added to the plannets.");
            return false;
        }
    }
}
