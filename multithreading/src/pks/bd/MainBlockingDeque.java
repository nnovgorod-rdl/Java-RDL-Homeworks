package pks.bd;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MainBlockingDeque {
    static final int STEP = 20;
    static final int MAX_INT_VALUE = 1000;
    static final int MAX_SLEEP = 100;
    static final int CONSUMER_SLEEP_ON_START = 200;
    static Random random = new Random();
    static SimpleProducer simpleProducer;
    static SimpleConsumer simpleConsumer;
    public static void main(String[] args) {
        BlockingDeque<Integer> integerBlockingDeque = new LinkedBlockingDeque<>();
        simpleProducer = new SimpleProducer(integerBlockingDeque);
        simpleConsumer = new SimpleConsumer(integerBlockingDeque);

        Thread producer = new Thread(simpleProducer);
        Thread consumer = new Thread(simpleConsumer);

        producer.start();
        consumer.start();
    }
}
