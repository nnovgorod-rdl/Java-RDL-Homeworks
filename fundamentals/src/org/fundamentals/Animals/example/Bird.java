package org.fundamentals.Animals.example;

public class Bird extends Animal implements Sing, BirdSound {
    @Override
    protected String getName() {
        return "Bird";
    }
}
