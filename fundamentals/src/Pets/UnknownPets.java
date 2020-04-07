package Pets;

public class UnknownPets extends Pets {

    private String name;

    UnknownPets(String name) {
        this.name = name;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    public String specification() {
        return "magib";
    }

    @Override
    public String type() {
        return "unseeng";
    }
}
