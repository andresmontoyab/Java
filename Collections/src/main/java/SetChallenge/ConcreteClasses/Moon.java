package SetChallenge.ConcreteClasses;


import SetChallenge.HeavenlyBoddy;
import SetChallenge.TypesHeavenlyBody;

public class Moon extends HeavenlyBoddy {

    public Moon(String name, double orbintalPeriod) {
        super(name, orbintalPeriod, TypesHeavenlyBody.MOON);
    }

    @Override
    public boolean addBody(HeavenlyBoddy moon) {
        System.out.println("Im a moon, i cant have satellities");
        return false;
    }
}
