package pks.bd;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MainBlockingDeque {
    static final int STEP = 20;
    static final int MAX_INT_VALUE = 1000;

    /*
    Поиграться можно изменяя CONSUMER_SLEEP_ON_START и PRODUCER_SLEEP_ON_START
     */
    static final int CONSUMER_SLEEP_ON_START_MS = 9000;
    static final int PRODUCER_SLEEP_ON_START_MS = 90;
    /*
    Зачем здесь слипы? и Зачем слип, если он и так блочится?
    Я сделал sleep в начале запуска у Producer и Consumer, что бы можно было "поиграться"
    Например, сначала запустить Producer и он бы "заполнил" BlockingDeque
    И начал ждать, когда Consumer, начнет "забирать"
    И наоборот, запустить Consumer, что бы он ждал, когда начнут "заполнять" BlockingDeque

    Лишние sleep, там где они блочатся убрал
     */
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
