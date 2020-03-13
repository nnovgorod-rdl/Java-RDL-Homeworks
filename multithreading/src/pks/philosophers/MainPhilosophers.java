package pks.philosophers;

public class MainPhilosophers {
    static final int NUMBER_OF_PHILOSOPHERS_FORKS = 5;

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS_FORKS];
        Object[] forks = new Object[NUMBER_OF_PHILOSOPHERS_FORKS];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {

            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            /*
            philosophers[i] = new Philosopher(rightFork, leftFork);
            ловим Deadlock

            И Ваше решение
            Попробую еще найти все таки для себя, решение с Официантом, которое, я бы понял. Пока все что нахожу
            вроде понятно, но не до конца, а просто копипастить не хочется :-)
             */

            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
