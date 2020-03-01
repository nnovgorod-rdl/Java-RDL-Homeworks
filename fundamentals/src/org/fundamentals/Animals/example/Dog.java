package org.fundamentals.Animals.example;

public class Dog extends Animal implements BringAStick, DogSound {
    @Override
    protected String getName() {
        return "Dog";
    }
}
