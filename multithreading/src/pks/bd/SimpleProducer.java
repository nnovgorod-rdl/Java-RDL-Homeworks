package pks.bd;

import java.util.concurrent.BlockingDeque;

 class SimpleProducer implements Runnable {
    private final BlockingDeque<Integer> integerBlockingDeque;

     SimpleProducer(BlockingDeque<Integer> integerBlockingDeque) {
        this.integerBlockingDeque = integerBlockingDeque;
    }

    @Override
    public void run() {
        System.out.println("SimpleProducer is started");
        try {
            for (int i = 0; i < MainBlockingDeque.STEP; i++) {
               int value =  MainBlockingDeque.random.nextInt(MainBlockingDeque.MAX_INT_VALUE);
                integerBlockingDeque.putFirst(value);
                //Тут он, как я понимаю, если места нет, заблокировался

                System.out.println("SimpleProducer put " + value + " to BlockingDeque");

                //переназначу int, для установки сна
                value = MainBlockingDeque.random.nextInt(MainBlockingDeque.MAX_SLEEP);
                Thread.sleep(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
