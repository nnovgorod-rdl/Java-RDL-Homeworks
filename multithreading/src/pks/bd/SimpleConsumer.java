package pks.bd;

import java.util.concurrent.BlockingDeque;

class SimpleConsumer implements Runnable {
    private final BlockingDeque<Integer> integerBlockingDeque;

    SimpleConsumer(BlockingDeque<Integer> integerBlockingDeque) {
        this.integerBlockingDeque = integerBlockingDeque;
    }

    @Override
    public void run() {
        System.out.println("SimpleConsumer is started");
        try {
            Thread.sleep(MainBlockingDeque.CONSUMER_SLEEP_ON_START_MS);
            for (int i = 0; i < MainBlockingDeque.STEP; i++) {
                int value;
                if (i % 2 == 0) {
                    value = integerBlockingDeque.takeFirst();
                } else {
                    value = integerBlockingDeque.takeLast();
                }
                //Тут он, как я понимаю, если забирать нечего, заблокировался

                System.out.println("SimpleConsumer get " + value + " from BlockingDeque");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
