package Pets;

public interface Fish extends Typization {
    @Override
    default String type() {
        return "swim";
    }
}
