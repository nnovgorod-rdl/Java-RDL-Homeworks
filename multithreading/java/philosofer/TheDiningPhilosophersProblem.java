package philosofer;

public class TheDiningPhilosophersProblem {
    public static void main(String[] args) throws Exception {

        Philosopher[] philosophers = new Philosopher[5];
        Fork[] forks = new Fork[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
            forks[i].numberOfFork = ""+ i;
        }
        for (int i = 0; i < philosophers.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % forks.length];
            String name = "Philosofer " + i;
            philosophers[i] = new Philosopher(name, leftFork, rightFork);
            philosophers[i].start();}

    }
}
