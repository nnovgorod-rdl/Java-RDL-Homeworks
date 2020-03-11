package pks.bd;

import java.util.concurrent.BlockingDeque;

public class SimpleProducer implements Runnable {
    private final BlockingDeque<Integer> integerBlockingDeque;

    public SimpleProducer(BlockingDeque<Integer> integerBlockingDeque) {
        this.integerBlockingDeque = integerBlockingDeque;
    }

    @Override
    public void run() {
        System.out.println("SimpleProducer is started");

    }
}
