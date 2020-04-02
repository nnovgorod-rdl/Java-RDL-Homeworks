package pks.prototype;

public interface ICreature {
    String getName(); // имя

    void setName(String name);

    ICreature copy(); // сделать клона
}
