package SetChallenge;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBoddy {

    private final String name;
    private final double orbintalPeriod;
    private final Set<HeavenlyBoddy> satallities;
    private TypesHeavenlyBody bodyType;

    public  HeavenlyBoddy(String name, double orbintalPeriod, TypesHeavenlyBody bodyType) {
        this.name = name;
        this.orbintalPeriod = orbintalPeriod;
        this.bodyType = bodyType;
        this.satallities = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbintalPeriod() {
        return orbintalPeriod;
    }

    public boolean addBody(HeavenlyBoddy moon) {
        return this.satallities.add(moon);
    }

    public Set<HeavenlyBoddy> getSatallities() {
        return new HashSet<>(this.satallities); // swallow copy
    }

    public TypesHeavenlyBody getBodyType() {
        return bodyType;
    }

    public final int hashCode() {
        return this.getName().hashCode() + this.getBodyType().toString().hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj){
            //same object
            return  true;
        }

        if (obj instanceof HeavenlyBoddy) {
            HeavenlyBoddy theObject = (HeavenlyBoddy) obj;
            if (this.getName().equals(((HeavenlyBoddy) obj).getName())) {
                return this.getBodyType().toString().equals(((HeavenlyBoddy) obj).getBodyType().toString());
            }
        }
        return false;
    }
}
