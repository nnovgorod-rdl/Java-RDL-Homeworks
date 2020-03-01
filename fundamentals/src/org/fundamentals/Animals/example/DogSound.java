package org.fundamentals.Animals.example;

public interface DogSound extends Sound {
    @Override
    default String voice() {
        return "Woof";
    }
}
