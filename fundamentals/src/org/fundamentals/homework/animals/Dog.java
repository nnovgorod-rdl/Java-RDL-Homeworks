package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.HouseProtect;
import org.fundamentals.homework.voices.Bark;

public class Dog extends Animal implements Bark, HouseProtect {
    @Override
    String getAnimalName() {
        return "Dog";
    }
}
