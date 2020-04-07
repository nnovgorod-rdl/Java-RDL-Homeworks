package Pets;

public class Main2 {
    public static void main(String[] args) {
        printLanguageDescription(getPetsByName(args[0]));
    }

    private static Pets getPetsByName(String name) {
        switch (name.toLowerCase()) {
            case "dog":
                return new Psina();
            case "sudak":
            case "tudak":
                return new Sudak();
            case "udav":
                return new Udav();
            default:
                return new UnknownPets(name);
        }
    }

    private static void printLanguageDescription(Pets pets) {
        System.out.println(pets.getDescription());
    }
}
