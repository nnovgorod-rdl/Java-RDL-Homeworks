package pks.prototype;

import java.util.Objects;

public class Creature extends ACreature {
    public Creature(String name) {
        super();
        super.name = name;
    }


    public String getName() {
        return super.name;
    }

    public void setName(String name) {
        super.name = name;
    }

    public ICreature copy() {
        return new Creature(name);
    }


    /*
    Может сам "нарываюсь". Но, нормальная реализация equals и hashCode?
     */
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Creature)) {
            return false;
        }
        Creature creature = (Creature) o;
        return name == creature.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                '}';
    }
}
