package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.Action;
import org.fundamentals.homework.voices.Voice;

public interface Animal extends Voice, Action {

    String getAnimalName();

    default String getDescription() {
        return getAnimalName() + " says " + animalVoice() + " and " + animalAction();
    }

}
