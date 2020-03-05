package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

/*
Мною было выбрано для битвы ArrayList и HashSet
И появился вопрос, как их сравнить?!
Решил, что сравнивать буду

1 - добавление элементов
2 - поиск вхождения элемента в коллекцию, по значению элемента
ArrayList.indexOf(Object o) или HaspSet.contains(Object o)
3 - удаление элементов, по значению элемента
ArrayList.remove(Object o) или HaspSet.remove(Object o)
Хотя удаление наверное зря, оно не сильно будет отличаться от поиска

Результаты, окончательно доделанные на работе с учетом форматирования double, что бы ТОЧНО сравнить
В прошлый раз не учел (ступил), что double любит выводить 0.15e-7

Количество элементов для добавления - 1000000.
Количество элементов для поиска - 700;
Количество элементов для удаления - 500;

1 - добавление элементов
Add 1000000 elements to class java.util.ArrayList is 209201800 nano seconds
Or 0,209201800000000 seconds

Add 1000000 elements to class java.util.HashSet is 1722269500 nano seconds
Or 1,722269500000000 seconds

ArrayList уверенно вырвался вперед, что не удивительно, т.к. ему не нужно рассчитывать Hash, каждому добавляемому
элементу и проверять, есть ли такой элемент уже в коллекции.
HashSet - т.к. содержит только "уникальные" элементы, тратит время на проверку уникальности и расчет Hash'а
------
2 - поиск вхождения элемента в коллекцию, по значению элемента
Find 700 elements in class java.util.ArrayList is 3843853400 nano seconds
Or 3,843853400000000 seconds

Find 700 elements in class java.util.HashSet is 553000 nano seconds
Or 0,000553000000000 seconds

Безоговорочное лидерство HashSet, потратив при добавлении время на расчет Hash'а, теперь он с его помощью
с легкостью ищет элементы, по значению
------
3 - удаление элементов, по значению элемента
Delete 700 elements in class java.util.ArrayList is 2501267300 nano seconds
Or 2,501267300000000 seconds

Delete 700 elements in class java.util.HashSet is 494200 nano seconds
Or 0,000494200000000 seconds

Похожая ситуация и при удалении элемента по значению, HashSet с легкостью находит и удаляет элементы по значению,
с легкостью опережаю ArrayList

PS SonarLint и IDEA немного ругается, что еще можно немного почистить код, будем считать,
что это мой первый технический долг :-)

 */

public class WarBetweenArrayListAndHashSet {
    static final ArrayList<String> arrayListOfString = new ArrayList<>();
    static final HashSet<String> hashSetOfStrings = new HashSet<>();
    static final String ELEMENTS_IN = " elements in ";
    static final String NANO_SECONDS = " nano seconds";
    static final String SOMETHING_WRONG = "Something wrong!!!";
    public static final String SECONDS = " seconds\r\n";

    static ArrayList<String> stringsToFind = new ArrayList<>();
    static final HashSet<String> stringsToFindSet = new HashSet<>();
    static ArrayList<String> stringsToDelete = new ArrayList<>();
    static final HashSet<String> stringsToDeleteSet = new HashSet<>();

    static final String PART_OF_VALUE_T0_COLLECTION = "StringValue";

    //TODO можно добавить 0, в конце переменной NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION, окончательно
    //TODO доделывал на ноутбуке, и на работе, а там с 10000000 вываливался в: java.lang.OutOfMemoryError:
    //TODO Java heap space :-) я смог убить JVM :-)
    static final int NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION = 1000000;
    static final int NUMBER_OF_ELEMENTS_TO_FIND = 700;
    static final int NUMBER_OF_ELEMENTS_TO_DELETE = 500;

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

    static void deleteElements(Collection<String> full, Collection<String> del) {
        if (full.getClass().toString().endsWith("ArrayList")) {
            deleteElementsInArray((ArrayList<String>) full, (ArrayList<String>) del);
        } else {
            deleteElementsInSet((HashSet<String>) full, (ArrayList<String>) del);
        }
    }

    static void deleteElementsInArray(ArrayList<String> full, ArrayList<String> del) {
        start = getNanoTime();
        for (String s : del) {
            boolean isElementDel = full.remove(s);
            if (!isElementDel) {
                System.out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Delete " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + String.format("%.15f", getSeconds(resultNanoTime)) + SECONDS);
    }

    static void deleteElementsInSet(HashSet<String> full, ArrayList<String> del) {
        start = getNanoTime();
        for (String s : del) {
            boolean isElementDel = full.remove(s);
            if (!isElementDel) {
                System.out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Delete " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + String.format("%.15f", getSeconds(resultNanoTime)) + SECONDS);
    }

    static void findElements(Collection<String> full, Collection<String> find) {
        if (full.getClass().toString().endsWith("ArrayList")) {
            findElementsInArray((ArrayList<String>) full, (ArrayList<String>) find);
        } else {
            findElementInSet((HashSet<String>) full, (ArrayList<String>) find);
        }
    }

    static void findElementsInArray(ArrayList<String> full, ArrayList<String> find) {
        start = getNanoTime();
        for (String s : find) {
            int isElementFind = full.indexOf(s);
            if (isElementFind == -1) {
                System.out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Find " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + String.format("%.15f", getSeconds(resultNanoTime)) + SECONDS);
    }

    static void findElementInSet(HashSet<String> full, ArrayList<String> find) {
        start = getNanoTime();
        for (String s : find) {
            boolean isElementFind = full.contains(s);
            if (!isElementFind) {
                System.out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = finish - start;
        System.out.println("Find " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        System.out.println("Or " + String.format("%.15f", getSeconds(resultNanoTime)) + SECONDS);
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
        System.out.println("Or " + String.format("%.15f", getSeconds(resultNanoTime)) + SECONDS);

    }

    static void addValueToCollectionString(Collection<String> c) {
        for (int i = 0; i < NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION; i++) {
            c.add(PART_OF_VALUE_T0_COLLECTION + i);
        }
    }

}
