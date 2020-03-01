package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.SomethingMake;
import org.fundamentals.homework.voices.SomeVoice;

public class Unknown implements Animal, SomeVoice, SomethingMake {
    @Override
    public String getAnimalName() {
        return "Unknown animal";
    }
}
