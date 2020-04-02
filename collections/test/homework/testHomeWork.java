package homework;

import io.humb1t.ConcurrentLinkedQueueExample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Queue;

public class testHomeWork {
    @Test
    public void assertFieldClassFromTest() {
        /*
        Лезем в статический вложенный класс Тест, "возщем изгаляемся"
         */
        ConcurrentLinkedQueueExample.Test test = new ConcurrentLinkedQueueExample.Test();
        test.assertFieldClass();
    }

    @Test
    public void assertFieldClassFromTestReflection() throws NoSuchFieldException {
        /*
        Попытка через Reflection, пока мало чего придумывается, что можно сделать...
         */
        Field field = ConcurrentLinkedQueueExample.class.getDeclaredField("queue");
        field.setAccessible(true);
        System.out.println(field.getType());
        Assertions.assertEquals(field.getType(), Queue.class);
    }
}
