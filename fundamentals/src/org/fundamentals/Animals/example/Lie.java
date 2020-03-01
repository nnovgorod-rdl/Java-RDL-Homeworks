package org.fundamentals.Animals.example;

public interface Lie extends Action {
    @Override
    default String action() {
        return "lie down majestically";
    }
}
