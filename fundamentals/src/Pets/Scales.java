package Pets;

public interface Scales extends Coating {
    @Override
    default String specification() {
        return "Scales";
    }
}
