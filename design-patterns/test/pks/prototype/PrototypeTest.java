package pks.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrototypeTest {
    static Planet planet;

    @BeforeAll
    static void init() {
        planet = new Planet();
    }

    @BeforeEach
    void cleanPlanet() {
        planet = null;
        planet = new Planet();
    }

    @Test
    public void planetTest() {
        Assertions.assertNotNull(planet);
        Assertions.assertEquals(0, planet.getPopulation());
        Assertions.assertEquals(Planet.class, planet.getClass());
    }

    @Test
    public void creatureTest() {
        ICreature creature = new Creature("A");
        Assertions.assertEquals(Creature.class, creature.getClass());
        ICreature copy = creature.copy();
        Assertions.assertEquals(creature.getClass(), copy.getClass());
        Assertions.assertTrue(creature.equals(copy));
        copy.setName("B");
        Assertions.assertFalse(creature.equals(copy));
    }

    @Test
    public void addCreatureToPlanet() {
        ICreature creature = new Creature("A");
        ICreature copy = creature.copy();
        copy.setName("B");
        planet.addCreature(creature);
        planet.addCreature(copy);
        Assertions.assertEquals(2, planet.getPopulation());
        Assertions.assertEquals("A", planet.creatures.get(0).getName());
        Assertions.assertEquals("B", planet.creatures.get(1).getName());
    }
}
