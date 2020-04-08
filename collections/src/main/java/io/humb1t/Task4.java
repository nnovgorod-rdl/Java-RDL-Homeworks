package io.humb1t;
/*
        Imagine the situation when you have a Collection and should remove all duplicates in it. How would you do it?
        in this situation i will use Set
        Implement your solution using only Java SE.*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;

public class Task4 {
    public static void main4() {
        CopyOnWriteArraySet<Integer> ArrSet = new CopyOnWriteArraySet<Integer>();
        //Just in case, i use CopyOnWriteArraySet.
        Collection<String> list2 = new ArrayList<>();
        CopyOnWriteArraySet<String> setlist = new CopyOnWriteArraySet<>();
        setlist.addAll(list2);
    }
}
