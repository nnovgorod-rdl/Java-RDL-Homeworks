package pks.ent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pks.ent.reflection.*;

public class TestReflection {
    @Test
    @DisplayName("Test All Simple Classes")
    public void testSimpleClasses() {
        /*
        Ничего не приходит в голову, кроме того, что-бы проверить являются ли созданные "объекты"
        сущностями именно их классов
         */
        SimpleClassFirst simpleClassFirst = new SimpleClassFirst();
        SimpleClassFirstChild simpleClassFirstChild = new SimpleClassFirstChild();
        SimpleClassFourth simpleClassFourth = new SimpleClassFourth();
        SimpleClassFourthChild simpleClassFourthChild = new SimpleClassFourthChild();
        SimpleClassFourthSecondChild simpleClassFourthSecondChild = new SimpleClassFourthSecondChild();
        SimpleClassSecond simpleClassSecond = new SimpleClassSecond();
        SimpleClassSecondChild simpleClassSecondChild = new SimpleClassSecondChild();
        SimpleClassThird simpleClassThird = new SimpleClassThird();
        SimpleClassThirdChild simpleClassThirdChild = new SimpleClassThirdChild();

        Assertions.assertEquals(SimpleClassFirst.class, simpleClassFirst.getClass());
        Assertions.assertEquals(SimpleClassFirstChild.class, simpleClassFirstChild.getClass());
        Assertions.assertEquals(SimpleClassFourth.class, simpleClassFourth.getClass());
        Assertions.assertEquals(SimpleClassFourthChild.class, simpleClassFourthChild.getClass());
        Assertions.assertEquals(SimpleClassFourthSecondChild.class, simpleClassFourthSecondChild.getClass());
        Assertions.assertEquals(SimpleClassSecond.class, simpleClassSecond.getClass());
        Assertions.assertEquals(SimpleClassSecondChild.class, simpleClassSecondChild.getClass());
        Assertions.assertEquals(SimpleClassThird.class, simpleClassThird.getClass());
        Assertions.assertEquals(SimpleClassThirdChild.class, simpleClassThirdChild.getClass());
    }
}
