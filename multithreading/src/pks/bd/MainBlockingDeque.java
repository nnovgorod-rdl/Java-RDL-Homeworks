package pks.bd;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MainBlockingDeque {
    static final int STEP = 20;
    static final int MAX_INT_VALUE = 1000;
    static final int MAX_SLEEP = 100;
    /*
    Поиграться можно изменяя CONSUMER_SLEEP_ON_START и PRODUCER_SLEEP_ON_START
     */
    static final int CONSUMER_SLEEP_ON_START = 90;
    static final int PRODUCER_SLEEP_ON_START = 9000;
    static Random random = new Random();
    static SimpleProducer simpleProducer;
    static SimpleConsumer simpleConsumer;
    public static void main(String[] args) {
        BlockingDeque<Integer> integerBlockingDeque = new LinkedBlockingDeque<>(5);
        simpleProducer = new SimpleProducer(integerBlockingDeque);
        simpleConsumer = new SimpleConsumer(integerBlockingDeque);

        Thread producer = new Thread(simpleProducer);
        Thread consumer = new Thread(simpleConsumer);

        producer.start();
        consumer.start();
    }
}
