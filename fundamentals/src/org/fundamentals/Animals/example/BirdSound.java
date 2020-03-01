package org.fundamentals.Animals.example;

public interface BirdSound extends Sound{
    @Override
default String voice(){return "Tweet-tweet";}}