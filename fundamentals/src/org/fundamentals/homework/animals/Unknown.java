package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.SomethingMake;
import org.fundamentals.homework.voices.SomeVoice;

public class Unknown extends Animal implements SomeVoice, SomethingMake {
    @Override
    String getAnimalName() {
        return "Unknown animal";
    }
}
