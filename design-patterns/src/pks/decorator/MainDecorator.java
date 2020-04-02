package pks.decorator;

import ent.pks.decorator.decorators.*;

import static java.lang.System.out;

public class MainDecorator {
    public static void main(String[] args) {
        IMatrioshka matrioshka = new SimpleMatrioshka();
        out.println(matrioshka.decorate());
        IMatrioshka redMatrioshka = new RedMatrioshka(new SimpleMatrioshka());
        out.println(redMatrioshka.decorate());
        IMatrioshka purpleMatrioshka = new PurpleMatrioshka(new SimpleMatrioshka());
        out.println(purpleMatrioshka.decorate());
        IMatrioshka blueMatrioshka = new BlueMatrioshka(new SimpleMatrioshka());
        out.println(blueMatrioshka.decorate());
        IMatrioshka bigMatrioshka = new BigMatrioshka(new SimpleMatrioshka());
        out.println(bigMatrioshka.decorate());
        IMatrioshka bigRedMatrioshka = new BigMatrioshka(new RedMatrioshka(new SimpleMatrioshka()));
        out.println(bigRedMatrioshka.decorate());
        IMatrioshka bigPurpleMatrioshka = new BigMatrioshka(new PurpleMatrioshka(new SimpleMatrioshka()));
        out.println(bigPurpleMatrioshka.decorate());
    }
}
