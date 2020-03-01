package org.fundamentals.Animals.example;

public interface CatSound extends Sound {
    @Override
    default String voice() {
        return "Meow";
    }
}
