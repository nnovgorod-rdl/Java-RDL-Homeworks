package io.humb1t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class WarBetweenArrayListAndHashSet {
    static final ArrayList<String> arrayListOfString = new ArrayList<>();
    static final String STRING_ARRAY_LIST = "ArrayList<String>";
    static final HashSet<String> hashSetOfStrings = new HashSet<>();
    static final String STRING_HASH_SET = "HashSet<String>";
    public static final int NUMBER_OF_ELEMENTS_TO_ADD = 1000000;
    static long start;
    static long finish;

    public static void main(String[] args) {

        startAndFinish(arrayListOfString, STRING_ARRAY_LIST);
//        System.out.println(stringArrayList);
        startAndFinish(hashSetOfStrings, STRING_HASH_SET);
//        System.out.println(stringHashSet);
    }

    static void startAndFinish(Collection<String> c, String value) {
        start = System.currentTimeMillis();
        addValueToCollectionString(c);
        finish = System.currentTimeMillis();
        long result = finish - start;
//        double resultInSeconds = result / 1000;
        System.out.println("Add " + NUMBER_OF_ELEMENTS_TO_ADD + " elements to " + value + " is " + result + " ms");
//        System.out.println(result / 1000);

    }

    static void addValueToCollectionString(Collection<String> c) {
        for (int i = 1; i < NUMBER_OF_ELEMENTS_TO_ADD; i++) {
            c.add("StringValue" + i);
        }
    }

}
