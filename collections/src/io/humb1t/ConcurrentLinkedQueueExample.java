package io.humb1t;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* Вопрос 3 - пока для меня не решенный :-(
Многопоточность мы правда еще не проходили, но попробую переделать пример из интернета :-)

Про многопоточность знаю пока только что в Java она есть :-)
Знаю, что есть трудности при ее реализации...
На этом знания заканчиваются :-(
 */
public class ConcurrentLinkedQueueExample {
    protected static final Queue<String> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws InterruptedException {
        Thread processorFirst = new Thread(new ProcessorFirst());
        Thread processorSecond = new Thread(new ProcessorSecond());
        Thread processorThird = new Thread(new ProcessorThird());

        processorFirst.start();
        processorSecond.start();
        processorThird.start();

        while (processorFirst.isAlive() || processorSecond.isAlive() || processorThird.isAlive()) {
            Thread.sleep(1000);
        }

        System.out.println("______");
        System.out.println("");
        System.out.println(queue);
        System.exit(0);
    }


    static class ProcessorFirst implements Runnable {

        public void run() {
            System.out.println("ProcessorFirst started");
            try {
                for (int i = 1; i <= 10; i++) {
                    String str = "StringProcessorFirst" + i;
                    queue.add(str);
                    System.out.println("ProcessorFirst added : "
                            + str);
                    Thread.sleep(100);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static class ProcessorSecond implements Runnable {

        public void run() {
            System.out.println("ProcessorSecond started");
            try {
                for (int i = 1; i <= 10; i++) {
                    String str = "StringProcessorSecond" + i;
                    queue.add(str);
                    System.out.println("ProcessorSecond added : "
                            + str);
                    Thread.sleep(30);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static class ProcessorThird implements Runnable {

        public void run() {
            System.out.println("ProcessorThird started");
            try {
                for (int i = 1; i <= 10; i++) {
                    String str = "StringProcessorThird" + i;
                    queue.add(str);
                    System.out.println("ProcessorThird added : "
                            + str);
                    Thread.sleep(50);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
