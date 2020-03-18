package Pets;

public interface Skin extends Coating {
    @Override
    default String specification() {
        return "Skin";
    }
}
