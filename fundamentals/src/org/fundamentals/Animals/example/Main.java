package org.fundamentals.Animals.example;

public class Main{
    public static void main(String[] args) {
        printInformationAboutAnimal(getAnimalByName(args[0]));
    }

    private static Animal getAnimalByName(String name) {
        switch (name.toLowerCase()) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            case "bird":
                return new Bird();
            default:
                return new UnknownPet(name);
        }
    }

    private static void printInformationAboutAnimal(Animal animal) {
        System.out.println(animal.getDescription());
    }
}
