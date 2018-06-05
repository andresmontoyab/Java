package SetChallenge.ConcreteClasses;

import SetChallenge.HeavenlyBoddy;
import SetChallenge.TypesHeavenlyBody;

public class Star extends HeavenlyBoddy {

    public Star(String name, double orbintalPeriod) {
        super(name, orbintalPeriod, TypesHeavenlyBody.STAR);
    }
}
