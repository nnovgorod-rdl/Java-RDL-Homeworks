package pks.decorator.decorators;

public class BlueMatrioshka extends MatrioshkaDecorator {

    public BlueMatrioshka(IMatrioshka iMatrioshka) {
        super(iMatrioshka);
    }

    private String blue() {
        return " синего цвета";
    }

    @Override
    public String decorate() {
        return super.decorate() + blue();
    }
}
