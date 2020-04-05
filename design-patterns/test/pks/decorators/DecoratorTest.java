package pks.decorators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pks.decorator.decorators.BigMatrioshka;
import pks.decorator.decorators.RedMatrioshka;
import pks.decorator.decorators.SimpleMatrioshka;

public class DecoratorTest {
    @Test
    @DisplayName("Full Matrioshka's Test")
    public void matrioshkasTest() {
        Assertions.assertEquals(new SimpleMatrioshka().decorate(), "Матрешка");
        Assertions.assertEquals(new SimpleMatrioshka().getClass(), SimpleMatrioshka.class);

        Assertions.assertEquals(new RedMatrioshka(new SimpleMatrioshka()).decorate(), RedMatrioshka.class);
        Assertions.assertEquals(new RedMatrioshka(new SimpleMatrioshka()).decorate(), "Матрешка красного цвета");

        Assertions.assertEquals(new BigMatrioshka(new RedMatrioshka(new SimpleMatrioshka())).decorate(),
                BigMatrioshka.class);
        Assertions.assertEquals(new BigMatrioshka(new RedMatrioshka(new SimpleMatrioshka())).decorate(),
                "Большая Матрешка красного цвета");

    }
}
