package org.fundamentals.Animals.example;

public class UnknownPet extends Animal {

    private String name;

    UnknownPet(String name) {
        this.name = name;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    public String action() {
        return "unknown";
    }

    @Override
    public String voice() {
        return "unclear";
    }
}
