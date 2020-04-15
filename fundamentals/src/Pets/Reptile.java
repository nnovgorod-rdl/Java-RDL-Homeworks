package Pets;

public interface Reptile extends Typization {
    @Override
    default String type() {
        return "make shshsh";
    }
}
