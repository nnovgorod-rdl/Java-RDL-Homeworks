package io.humb1t;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExampleTest {
    /*
    Не знаю насколько это хорошо, но один из FAQ говорит - разместите тест там же где тестируемый класс

    How do I test protected methods?

    Place your tests in the same package as the classes under test.

    Refer to "Where should I put my test files?" for examples of how to organize tests for protected method access.
     */
    @Test
    public void queueClass() {
        Assertions.assertEquals(ConcurrentLinkedQueueExample.queue.getClass(), ConcurrentLinkedQueue.class);
    }

    @Test
    public void addToQueue() {
        ConcurrentLinkedQueueExample.queue.add("1");
        ConcurrentLinkedQueueExample.queue.add("2");
        Assertions.assertEquals(2, ConcurrentLinkedQueueExample.queue.size());
    }

    /*
    Конечно мало, но что то больше не придумывается.
     */
}
