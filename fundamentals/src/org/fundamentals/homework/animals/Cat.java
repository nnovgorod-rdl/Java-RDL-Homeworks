package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.MiceCatch;
import org.fundamentals.homework.voices.Meow;

public class Cat implements Animal, Meow, MiceCatch {
    @Override
    public String getAnimalName() {
        return "Cat";
    }
}
