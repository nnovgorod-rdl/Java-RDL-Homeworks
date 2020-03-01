package org.fundamentals.Animals.generic;

public class Main {
    public static void main(String[] args) {
        Animal animal = getAnimalByName(args[0]);
        System.out.println(animal.getDescription());
        System.out.println(animal.toString());
    }

    private static Animal getAnimalByName(String name) {
        switch (name.toLowerCase()) {
            case "cat":
                return new Animal("Cat", () -> "lie down majestically", () -> "Meow");
            case "dog":
                return new Animal("Dog", () -> "bring a stick", () -> "Woof");
            case "bird":
                return new Animal("Bird",() -> "sing under the window at 6 a.m.", () -> "Tweet-Tweet");
            default:
                return new Animal(name, new UnknownPet(), new UnknownPet());
        }
    }
}
