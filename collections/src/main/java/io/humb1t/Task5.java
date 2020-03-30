package io.humb1t;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 5.There is an old war between ArrayList and Linked List - choose new fighters and implement your own benchmark (Vector vs Queue for example). Write down your thoughts.
        i declare war between ArrayList and all others collection
        ArrayList is very easy to understanding, most often used, does not have unnecessary and confusing functionality
        */
public class Task5 {
    public static void main5() {
        List<Integer> arrL = new ArrayList<>();
        List<Integer> linkedL = new LinkedList<>();
        for (int i = 0; i < 10000; i+=5000) {
            testAdd(arrL, i);
            testAdd(linkedL, i);
            testremove(arrL, i);
            testremove(linkedL, i);
            testget(arrL, i);
            testget(linkedL, i);
            testset(arrL, i);
            testset(linkedL, i);
        }
    }

    public static void testAdd(List<Integer> list, int position) {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        Date startLinked = new Date();
        for (int i = 0; i < 10000; i++) {
            list.add(position, 1);
        }
        Date finishLinked = new Date();
        long linkedTime = finishLinked.getTime() - startLinked.getTime();
        System.out.println("Time test, position is  "+position+" name of list" + list.getClass() +" time - "+ linkedTime);
    }

        public static void testremove(List<Integer> list, int position) {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        Date startLinked = new Date();
        for (int i = 0; i < 10000; i++) {
            list.remove(position);
        }
        Date finishLinked = new Date();
        long linkedTime = finishLinked.getTime() - startLinked.getTime();
            System.out.println("Time test, position is  "+position+" name of list" + list.getClass() +" time - "+ linkedTime);
    }

    public static void testget(List<Integer> list, int position) {        for (int i = 0; i < 10000; i++) {
        list.add(i);
    }

        Date startLinked = new Date();
        for (int i = 0; i < 10000; i++) {
            list.get(position);
        }
        Date finishLinked = new Date();
        long linkedTime = finishLinked.getTime() - startLinked.getTime();
        System.out.println("Time test, position is  "+position+" name of list" + list.getClass() +" time - "+ linkedTime);
    }

    public static void testset(List<Integer> list, int position) {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        Date startLinked = new Date();
        for (int i = 0; i < 10000; i++) {
            list.set(position, 1);
        }
        Date finishLinked = new Date();
        long linkedTime = finishLinked.getTime() - startLinked.getTime();
        System.out.println("Time test, position is  "+position+" name of list" + list.getClass() +" time - "+ linkedTime);
    }

}
