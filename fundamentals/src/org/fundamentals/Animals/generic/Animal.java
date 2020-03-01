package org.fundamentals.Animals.generic;

public class Animal <A extends Action, S extends Sound > implements ObjectsWithGroupingAndBehavior{
    private String name;
    private A action;
    private S sound;

    public Animal(String name, A action, S sound) {
        this.name = name;
        this.action = action;
        this.sound = sound;
    }

    String getDescription() {
        return name + " makes a sound \"" + sound.voice() + "\" and can " + action.action();
    }

    @Override
    public A getGroup() {
        return action;
    }

    @Override
    public S getBehavior() {
        return sound;
    }

    @Override
    public String toString() {
        return "Animal<" + sound.getClass().getName() + "," + action.getClass().getName() + ">";
    }
}
