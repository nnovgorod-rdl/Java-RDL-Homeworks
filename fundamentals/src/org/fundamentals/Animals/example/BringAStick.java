package org.fundamentals.Animals.example;

public interface BringAStick extends Action {
    @Override
    default String action() {
        return "bring a stick";
    }
}
