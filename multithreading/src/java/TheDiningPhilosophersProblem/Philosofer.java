package TheDiningPhilosophersProblem;

import java.util.Random;

class Philosofer implements Runnable {
    volatile boolean stopFlag = false;
    int pos;
    Fork left;
    Fork right;
    private final Waitres waitres;
    int eatCount = 0;
    long waitTime = 0;
    long startWait;
    Random rnd = new Random();

    public Philosofer(int pos, Fork left, Fork right, Waitres waitres) {
        this.pos = pos;
        this.left = left;
        this.right = right;
        this.waitres = waitres;
    }

    public void run() {
        while (!stopFlag) {
            think();
            waitres.letMeEat(left, right, () -> {
                if (Thread.holdsLock(left) && Thread.holdsLock(right)) {
                    eat();
                } else {
                    throw new RuntimeException("Что то пошло не так");
                }
            });
        }
        System.out.println("Философ " + pos + " stop");
    }

    public static void main(String[] args) throws Exception {
        int count = 5;
        Fork[] forks = new Fork[count];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }
        Philosofer[] phils = new Philosofer[count];
        Waitres waitres = new Waitres();
        for (int i = 0; i < count; i++) {
            Fork left = forks[i];
            Fork right = (i == count - 1) ? forks[0] : forks[i + 1];
            phils[i] = new Philosofer(i, left, right, waitres);
        }
        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(phils[i]);
            threads[i].start();
        }
        Thread.sleep(60000);
        for (Philosofer phil : phils) {
            phil.stopFlag = true;
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public void eat() {
        waitTime += System.currentTimeMillis() + startWait;
        System.out.println("Философ " + pos + " ест");
        try {
            Thread.sleep(rnd.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eatCount++;
        System.out.println("Философ " + pos + " поел");
    }

    public void think() {
        System.out.println("Философ " + pos + " думает");
        try {
            Thread.sleep(rnd.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startWait = System.currentTimeMillis();
    }
}
