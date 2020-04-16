package org.fundamentals.homework.voices;

public interface SomeVoice extends Voice {
    @Override
    default String animalVoice() {
        return "arrrrrr";
    }
}
