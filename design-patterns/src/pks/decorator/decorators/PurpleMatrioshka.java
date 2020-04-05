package pks.decorator.decorators;

public class PurpleMatrioshka extends MatrioshkaDecorator {

    public PurpleMatrioshka(IMatrioshka iMatrioshka) {
        super(iMatrioshka);
    }

    private String purple() {
        return " фиолетового цвета";
    }

    @Override
    public String decorate() {
        return super.decorate() + purple();
    }
}
