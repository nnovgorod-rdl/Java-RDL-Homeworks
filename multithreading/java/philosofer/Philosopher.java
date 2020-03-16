package philosofer;

public class Philosopher extends Thread{
    String name;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(this.name + " " + action);
    }

    @Override
    public void run() {
        try {
            while (true) {
                //I'm not sure, but i was trying to solve deadlock by open calling method
                doAction(": Think");
                synchronized (leftFork){
                doAction(": Take fork " + leftFork.numberOfFork +" - eating");}
                synchronized (rightFork){
                doAction(": Take fork " + rightFork.numberOfFork +" - eating");}
                doAction(": Put down fork #" + rightFork.numberOfFork);
                doAction(":Put down fork #" + leftFork.numberOfFork);
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание");
            Thread.currentThread().interrupt();
            return;
        }
    }
}

