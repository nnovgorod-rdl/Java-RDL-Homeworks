package Pets;

public abstract class Pets implements Coating, Typization {
    protected abstract String getName();

    String getDescription() {
        return getName() + " have " + specification() + " and " + type() + " Pets.";
    }
}
