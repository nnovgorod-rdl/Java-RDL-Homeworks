package org.fundamentals.homework.actions;

public interface SomethingMake extends Action {
    @Override
    default String animalAction() {
        return "tigdin-tigdin";
    }
}
