package pks.decorator.decorators;

public class RedMatrioshka extends MatrioshkaDecorator {

    public RedMatrioshka(IMatrioshka iMatrioshka) {
        super(iMatrioshka);
    }

    private String red() {
        return " красного цета";
    }

    @Override
    public String decorate() {
        return super.decorate() + red();
    }
}
