package Sets;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBoddy  {

    private final String name;
    private final double orbintalPeriod;
    private final Set<HeavenlyBoddy> satallities;

    public HeavenlyBoddy(String name, double orbintalPeriod) {
        this.name = name;
        this.orbintalPeriod = orbintalPeriod;
        this.satallities = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbintalPeriod() {
        return orbintalPeriod;
    }

    public boolean addMoon(HeavenlyBoddy moon) {
        return this.satallities.add(moon);
    }

    public Set<HeavenlyBoddy> getSatallities() {
        return new HashSet<>(this.satallities); // swallow copy
    }
}
