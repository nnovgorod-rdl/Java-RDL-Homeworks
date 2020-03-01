package org.fundamentals.Animals.example;

public class Cat extends Animal implements Lie, CatSound {
    @Override
    protected String getName() {
        return "Cat";
    }
}
