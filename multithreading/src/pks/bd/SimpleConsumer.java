package pks.bd;

import java.util.concurrent.BlockingDeque;

public class SimpleConsumer implements Runnable {
    private final BlockingDeque<Integer> integerBlockingDeque;

    public SimpleConsumer(BlockingDeque<Integer> integerBlockingDeque) {
        this.integerBlockingDeque = integerBlockingDeque;
    }

    @Override
    public void run() {
        System.out.println("SimpleConsumer is started");
    }
}
