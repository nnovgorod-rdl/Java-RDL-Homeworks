package Pets;

public interface Wool extends Coating {
    @Override
    default String specification() {
        return "Wool";
    }
}
