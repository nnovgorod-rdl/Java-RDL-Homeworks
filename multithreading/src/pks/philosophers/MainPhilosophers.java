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

            И Ваше решение.

            25-03-2020 - Использовано решение показанное на лекции. К сожаленю в настоящее время примеров с другими
            понятными для меня решениями, не нашел.
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
