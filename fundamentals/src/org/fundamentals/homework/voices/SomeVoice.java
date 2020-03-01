package org.fundamentals.homework.voices;

public interface SomeVoice extends Voice{
    @Override
   default String voice(){
        return "arrrrrr";
    }
}
