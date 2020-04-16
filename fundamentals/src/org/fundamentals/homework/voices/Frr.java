package org.fundamentals.homework.voices;

public interface Frr extends Voice {
    @Override
    default String animalVoice() {
        return "frr";
    }
}
