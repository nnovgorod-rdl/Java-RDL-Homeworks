package pks.prototype;

import java.util.ArrayList;

public class Planet extends APlanet {

    public Planet() {
        creatures = new ArrayList<>();
    }

    public void addCreature(ICreature creature) {
        creatures.add(creature);
    }

    public long getPopulation() {
        return creatures.size();
    }
}
