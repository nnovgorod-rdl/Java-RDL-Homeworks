package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import static java.lang.System.nanoTime;
import static java.lang.System.out;

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
    static final ArrayList<String> ARRAY_LIST_OF_STRINGS = new ArrayList<>();
    static final HashSet<String> HASH_SET_OF_STRINGS = new HashSet<>();
    static final String ELEMENTS_IN = " elements in ";
    static final String NANO_SECONDS = " nano seconds";
    static final String SOMETHING_WRONG = "Something wrong!!!";
    static final String SECONDS = " seconds\r\n";
    static final String DOUBLE_STRING_FORMAT = "%.15f";
    static final ArrayList<String> STRINGS_TO_FIND = new ArrayList<>();
    static final HashSet<String> STRINGS_TO_FIND_SET = new HashSet<>();
    static final ArrayList<String> STRINGS_TO_DELETE = new ArrayList<>();
    static final HashSet<String> STRINGS_TO_DELETE_SET = new HashSet<>();
    static final String PART_OF_VALUE_T0_COLLECTION = "StringValue";
    static final int NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION = 1000000;
    static final int NUMBER_OF_ELEMENTS_TO_FIND = 700;
    static final int NUMBER_OF_ELEMENTS_TO_DELETE = 500;

    static Random random = new Random();

    static long start;
    static long finish;

    public static void main(String[] args) {
        setElementToFind();
        setElementToDelete();
        startAndFinish(ARRAY_LIST_OF_STRINGS);
        startAndFinish(HASH_SET_OF_STRINGS);
        findElements(ARRAY_LIST_OF_STRINGS, STRINGS_TO_FIND);
        findElementInSet(HASH_SET_OF_STRINGS, STRINGS_TO_FIND);
        deleteElements(ARRAY_LIST_OF_STRINGS, STRINGS_TO_DELETE);
        deleteElements(HASH_SET_OF_STRINGS, STRINGS_TO_DELETE);
    }

    static void setElementToFind() {
        while (STRINGS_TO_FIND_SET.size() < NUMBER_OF_ELEMENTS_TO_FIND) {
            STRINGS_TO_FIND_SET.add(PART_OF_VALUE_T0_COLLECTION + random.nextInt(NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION));
        }
        STRINGS_TO_FIND.addAll(STRINGS_TO_FIND_SET);
    }

    static void setElementToDelete() {
        while (STRINGS_TO_DELETE_SET.size() < NUMBER_OF_ELEMENTS_TO_DELETE) {
            STRINGS_TO_DELETE_SET.add(PART_OF_VALUE_T0_COLLECTION + random.nextInt(NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION));
        }
        STRINGS_TO_DELETE.addAll(STRINGS_TO_DELETE_SET);
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
                out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = resultNanoTime(finish, start);
        out.println("Delete " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        out.println("Or " + String.format(DOUBLE_STRING_FORMAT, getSeconds(resultNanoTime)) + SECONDS);
    }

    static long resultNanoTime(long begin, long end) {
        return end - begin;
    }

    static void deleteElementsInSet(HashSet<String> full, ArrayList<String> del) {
        start = getNanoTime();
        for (String s : del) {
            boolean isElementDel = full.remove(s);
            if (!isElementDel) {
                out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = resultNanoTime(finish, start);
        out.println("Delete " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        out.println("Or " + String.format(DOUBLE_STRING_FORMAT, getSeconds(resultNanoTime)) + SECONDS);
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
                out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = resultNanoTime(finish, start);
        out.println("Find " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        out.println("Or " + String.format(DOUBLE_STRING_FORMAT, getSeconds(resultNanoTime)) + SECONDS);
    }

    static void findElementInSet(HashSet<String> full, ArrayList<String> find) {
        start = getNanoTime();
        for (String s : find) {
            boolean isElementFind = full.contains(s);
            if (!isElementFind) {
                out.println(SOMETHING_WRONG);
                return;
            }
        }
        finish = getNanoTime();
        long resultNanoTime = resultNanoTime(finish, start);
        out.println("Find " + NUMBER_OF_ELEMENTS_TO_FIND + ELEMENTS_IN + full.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        out.println("Or " + String.format(DOUBLE_STRING_FORMAT, getSeconds(resultNanoTime)) + SECONDS);
    }

    static long getNanoTime() {
        return nanoTime();
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
        long resultNanoTime = resultNanoTime(finish, start);
        out.println("Add " + NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION + " elements to " + c.getClass().toString() + " is " + resultNanoTime + NANO_SECONDS);
        out.println("Or " + String.format(DOUBLE_STRING_FORMAT, getSeconds(resultNanoTime)) + SECONDS);

    }

    static void addValueToCollectionString(Collection<String> c) {
        for (int i = 0; i < NUMBER_OF_ELEMENTS_TO_ADD_IN_COLLECTION; i++) {
            c.add(PART_OF_VALUE_T0_COLLECTION + i);
        }
    }

}
