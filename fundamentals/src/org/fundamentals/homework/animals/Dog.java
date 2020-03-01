package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.HouseProtect;
import org.fundamentals.homework.voices.Bark;

public class Dog implements Animal, Bark, HouseProtect {
    @Override
    public String getAnimalName() {
        return "Dog";
    }
}
