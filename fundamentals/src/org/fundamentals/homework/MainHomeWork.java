package org.fundamentals.homework;

import org.fundamentals.homework.animals.*;

public class MainHomeWork {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You're not entered any animal");
        } else {
            printAnimalDescription(getAnimalName(args[0]));
        }
    }

    private static Animal getAnimalName(String name) {
        switch (name.toLowerCase()) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
            case "hedgehog":
                return new Hedgehog();
            default:
                return new Unknown();
        }
    }

    private static void printAnimalDescription(Animal animal) {
        System.out.println(animal.getDescription());
    }
}
