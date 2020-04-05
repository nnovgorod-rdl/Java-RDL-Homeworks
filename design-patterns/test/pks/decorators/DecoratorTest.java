package pks.decorators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pks.decorator.decorators.BigMatrioshka;
import pks.decorator.decorators.IMatrioshka;
import pks.decorator.decorators.RedMatrioshka;
import pks.decorator.decorators.SimpleMatrioshka;

public class DecoratorTest {
    @Test
    @DisplayName("Full Matrioshka's Test")
    public void matrioshkasTest() {
        IMatrioshka simpleMatrioshka = new SimpleMatrioshka();
        IMatrioshka redMatrioshka = new RedMatrioshka(new SimpleMatrioshka());
        IMatrioshka bigRedMatrioshka = new BigMatrioshka(new RedMatrioshka(new SimpleMatrioshka()));

        Assertions.assertEquals(SimpleMatrioshka.class, simpleMatrioshka.getClass());
        Assertions.assertEquals("Матрешка", simpleMatrioshka.decorate());

        Assertions.assertEquals(RedMatrioshka.class, redMatrioshka.getClass());
        Assertions.assertEquals("Матрешка красного цвета", redMatrioshka.decorate());

        Assertions.assertEquals(BigMatrioshka.class, bigRedMatrioshka.getClass());
        Assertions.assertEquals("Большая Матрешка красного цвета", bigRedMatrioshka.decorate());

    }
}
