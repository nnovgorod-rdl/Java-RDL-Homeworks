package org.fundamentals.homework.animals;

import org.fundamentals.homework.actions.Action;
import org.fundamentals.homework.voices.Voice;

public abstract class Animal implements Voice, Action {
    abstract String getAnimalName();

   public String getDescription() {
        return getAnimalName() + " says " + voice() + " and " + action();
    }
    
}
