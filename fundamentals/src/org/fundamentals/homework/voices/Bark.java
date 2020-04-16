package org.fundamentals.homework.voices;

public interface Bark extends Voice {
    @Override
    default String animalVoice() {
        return "woof";
    }
}
