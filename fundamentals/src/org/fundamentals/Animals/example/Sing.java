package org.fundamentals.Animals.example;

public interface Sing extends Action {
    @Override
    default String action() {
        return "sing under the window at 6 a.m.";
    }
}
