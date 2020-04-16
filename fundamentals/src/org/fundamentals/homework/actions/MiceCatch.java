package org.fundamentals.homework.actions;

public interface MiceCatch extends Action {
    @Override
    default String animalAction() {
        return "catching mice";
    }
}
