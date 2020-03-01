package org.fundamentals.Animals.example;

public abstract class Animal implements Action, Sound {
    protected abstract String getName();

    String getDescription() {
        return getName() + " makes a sound \"" + voice() + "\" and can " + action();
    }
}
