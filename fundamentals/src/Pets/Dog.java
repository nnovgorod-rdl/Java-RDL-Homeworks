package Pets;

public interface Dog extends Typization {
    @Override
    default String type() {
        return "Gaw";
    }
}
