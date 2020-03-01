package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.MiceCatch;
import org.fundamentals.homework.voices.Meow;

public class Cat extends Animal implements Meow, MiceCatch {
    @Override
    String getAnimalName() {
        return "Cats";
    }
}
