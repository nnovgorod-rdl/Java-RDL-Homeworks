package pks.decorator.decorators;

public abstract class MatrioshkaDecorator implements IMatrioshka {

   final IMatrioshka iMatrioshka;

    public MatrioshkaDecorator(IMatrioshka iMatrioshka) {
        this.iMatrioshka = iMatrioshka;
    }

    public String decorate() {
        return iMatrioshka.decorate();
    }
}
