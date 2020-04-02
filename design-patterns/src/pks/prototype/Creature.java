package pks.prototype;

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

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                '}';
    }
}
