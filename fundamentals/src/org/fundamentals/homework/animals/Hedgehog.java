package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.MiceCatch;
import org.fundamentals.homework.voices.Frr;

public class Hedgehog extends Animal implements Frr, MiceCatch {
    @Override
    String getAnimalName() {
        return "Hedgehog";
    }
}
