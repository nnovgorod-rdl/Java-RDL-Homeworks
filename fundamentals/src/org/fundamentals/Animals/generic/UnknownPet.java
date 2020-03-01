package org.fundamentals.Animals.generic;

public class UnknownPet implements Action, Sound {

    @Override
    public String action() {
        return "unknown";
    }

    @Override
    public String voice() {
        return "unknown";
    }
}
