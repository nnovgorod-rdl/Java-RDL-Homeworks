package io.humb1t.cache;

import java.util.HashMap;
import java.util.HashSet;

public class CacheMapMain {
    static final HashMap<String, HashSet<String>> cache = new HashMap<>();
    static final HashSet<String> hddSet = new HashSet<>();
    static final HashSet<String> ramSet = new HashSet<>();

    public static void main(String[] args) {
        firstFillMap();
        System.out.println(cache);
    }

    static void firstFillMap() {
        //Конечно нужно бы считать какой нибудь файл с диска, и в конце работы программы, записать, что это есть на HDD
        firstFillHDDSet();
        cache.put("HDD", hddSet);

        addToSet(ramSet, "advertising.xyz"); //пойманный и пока не удаленный рекламный баннер, с автозагрузкой
        cache.put("RAM", ramSet);
    }

    static void firstFillHDDSet() {
        addToSet(hddSet, "yandex.ru");
        addToSet(hddSet, "training.ru");
        addToSet(hddSet, "learn.by");
        addToSet(hddSet, "google.com");
        addToSet(hddSet, "stackoverflow.com");
        addToSet(hddSet, "advertising.xyz");//пойманный и пока не удаленный рекламный баннер, с автозагрузкой
    }

    static void addToSet(HashSet<String> hashSet, String value) {
        hashSet.add(value);
    }

    static void printNotFound() {
        System.out.println("Сайт не найден, ни в RAM, ни на HDD, поэтому загружаем из интернета");
    }

    static void printFoundHDD() {
        System.out.println("Сайт найден на HDD, загружен в RAM и показан быстро");
    }

    static void printFoundRAM() {
        System.out.println("Сайт найден в RAM, и показан моментально");
    }
}
