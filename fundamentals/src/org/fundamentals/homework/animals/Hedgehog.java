package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.MiceCatch;
import org.fundamentals.homework.voices.Frr;

public class Hedgehog implements Animal, Frr, MiceCatch {
    @Override
    public String getAnimalName() {
        return "Hedgehog";
    }
}
