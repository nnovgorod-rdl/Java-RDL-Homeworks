package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/*
Мною ьыло выбрано для битвы ArrayList и HashSet
И появился вопрос, как их сравнить?!
Решил, что сравинивать буду

1 - добавление элементов
2 - поиск вхождения элемента в коллекцию, по значению элемента
ArrayList.indexOf(Object o) или HaspSet.contains(Object o)
3 - удаление элементов, по значению элемента
ArrayList.remove(Object o) или HaspSet.remove(Object o)
Хотя удаление наверное зря, оно не сильно будет отличаться от поиска

Результаты
Add 10000000 elements to class java.util.ArrayList is 7363549200 nano seconds
Or 7.3635492 seconds

Add 10000000 elements to class java.util.HashSet is 5219456800 nano seconds
Or 5.2194568 seconds


Find 700 elements in class java.util.ArrayList is 28155704400 nano seconds
Or 28.1557044 seconds

Find 700 elements in class java.util.HashSet is 672800 nano seconds
Or 6.728E-4 seconds

Delete 700 elements in class java.util.ArrayList is 20735544900 nano seconds
Or 20.7355449 seconds

Delete 700 elements in class java.util.HashSet is 541100 nano seconds
Or 5.411E-4 seconds


Process finished with exit code 0

Скорость работы по добавлению элементов:
ArrayList с незначительным отрывом проигрывает HashSet, что кстате для меня странно, нада видимо еще почитать
Ведь в моем понимании, HashSet еще должен тратить время на расчет Hash и поиск, нет ли уже такого элемента!

А вот в поиске и удалении элементов, по значению элемента ArrayList, я бы сказал, мог бы и не приходить на соревнование :-)
HashSet с помощью своего поиска по Hash'у оказывается в 4-е раза быстрее

PS SonarLint и IDEA немного ругае.тся, что еще можно немного почистить код, будем считать,
что это мой первый технический долг :-)

 */

public class WarBetweenArrayListAndHashSet {
    static final ArrayList<String> arrayListOfString = new ArrayList<>();
    static final HashSet<String> hashSetOfStrings = new HashSet<>();
    public static final String ELEMENTS_IN = " elements in ";
    public static final String NANO_SECONDS = " nano seconds";
    public static final String SOMETHING_WRONG = "Something wrong!!!";

    static ArrayList<String> stringsToFind = new ArrayList<>();
    static final HashSet<String> stringsToFindSet = new HashSet<>();
    static ArrayList<String> stringsToDelete = new ArrayList<>();
    static final HashSet<String> stringsToDeleteSet = new HashSet<>();

    static final String PART_OF_VALUE_T0_COLLECTION = "StringValue";

    public static final int NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION = 10000000;
    public static final int NUMBER_OF_ELEMENTS_TO_FIND = 700;
    public static final int NUMBER_OF_ELEMENTS_TO_DELETE = 500;

    static Random random = new Random();

    static long start;
    static long finish;

    public static void main(String[] args) {
        setElementToFind();
        setElementToDelete();
        startAndFinish(arrayListOfString);
        startAndFinish(hashSetOfStrings);
        findElements(arrayListOfString, stringsToFind);
        findElementInSet(hashSetOfStrings, stringsToFind);
        deleteElements(arrayListOfString, stringsToDelete);
        deleteElements(hashSetOfStrings, stringsToDelete);
    }

    static void setElementToFind() {
        while (stringsToFindSet.size() < NUMBER_OF_ELEMENTS_TO_FIND) {
            stringsToFindSet.add(PART_OF_VALUE_T0_COLLECTION + random.nextInt(NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION));
        }
        stringsToFind.addAll(stringsToFindSet);
    }

    static void setElementToDelete() {
        while (stringsToDeleteSet.size() < NUMBER_OF_ELEMENTS_TO_DELETE) {
            stringsToDeleteSet.add(PART_OF_VALUE_T0_COLLECTION + random.nextInt(NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION));
        }
        stringsToDelete.addAll(stringsToDeleteSet);
    }

    static void deleteElements(Collection full, Collection del) {
        if (full.getClass().toString().endsWith("ArrayList")) {
            deleteElementsInArray((ArrayList) full, (ArrayList) del);
        } else {
            deleteElementsInSet((HashSet) full, (ArrayList) del);
        }
    }

    static void deleteElementsInArray(ArrayList full, ArrayList del) {
        start = getNanoTime();
        for (Object o : del) {
            boolean isElementDel = full.remove(o);
            if (!isElementDel) {
                System.out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Delete " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + getSeconds(resultNanoTime) + " seconds\r\n");
    }

    static void deleteElementsInSet(HashSet full, ArrayList del) {
        start = getNanoTime();
        for (Object o : del) {
            boolean isElementDel = full.remove(o);
            if (!isElementDel) {
                System.out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Delete " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + getSeconds(resultNanoTime) + " seconds\r\n");
    }

    static void findElements(Collection full, Collection find) {
        if (full.getClass().toString().endsWith("ArrayList")) {
            findElementsInArray((ArrayList) full, (ArrayList) find);
        } else {
            findElementInSet((HashSet) full, (ArrayList) find);
        }
    }

    static void findElementsInArray(ArrayList full, ArrayList find) {
        start = getNanoTime();
        for (int i = 0; i < find.size(); i++) {
            int isElementFind = full.indexOf(find.get(i));
            if (isElementFind == -1) {
                System.out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Find " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + getSeconds(resultNanoTime) + " seconds\r\n");
    }

    static void findElementInSet(HashSet full, ArrayList find) {
        start = getNanoTime();
        for (Object o : find) {
            boolean isElementFind = full.contains(o);
            if (!isElementFind) {
                System.out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Find " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + getSeconds(resultNanoTime) + " seconds\r\n");
    }

    static long getNanoTime() {
        return System.nanoTime();
    }

    static double getSeconds(long value) {
        //на stackoverflow.com так же есть и другие варианты перевода в секунды,
        // но это самый простой, без доп класса TimeUnit
        return (double) value / 1_000_000_000.0;
    }

    static void startAndFinish(Collection<String> c) {
        start = getNanoTime();
        addValueToCollectionString(c);
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Add " + NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION + " elements to " + c.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + getSeconds(resultNanoTime) + " seconds\r\n");

    }

    static void addValueToCollectionString(Collection<String> c) {
        for (int i = 0; i < NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION; i++) {
            c.add(PART_OF_VALUE_T0_COLLECTION + i);
        }
    }

}
