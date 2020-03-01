package org.fundamentals.homework.voices;

public interface Meow extends Voice {
    @Override
    default String voice() {
        return "meow";
    }
}
