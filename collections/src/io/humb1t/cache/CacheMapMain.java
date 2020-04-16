package io.humb1t.cache;

import io.humb1t.cache.console.SimpleConsoleInput;
import io.humb1t.cache.console.SimpleConsoleOutput;

import java.util.HashMap;
import java.util.HashSet;

public class CacheMapMain {
    static final HashMap<String, HashSet<String>> cache = new HashMap<>();
    static final HashSet<String> hddSet = new HashSet<>();
    static final HashSet<String> ramSet = new HashSet<>();
    static String siteAddress = "";
    static boolean isQuit = false;
    static boolean isFirstRun = true;
    static SimpleConsoleInput simpleConsoleInput = new SimpleConsoleInput();
    static SimpleConsoleOutput simpleConsoleOutput = new SimpleConsoleOutput();

    public static void main(String[] args) {
        start();
    }

    static void start() {
        firstFillMap();
        workInInternet();
    }

    static void workInInternet() {
        do {
            if (isFirstRun) {
                simpleConsoleOutput.consoleOutput("Запускается браузер.");
                isFirstRun = false;
            }
            simpleConsoleOutput.consoleOutput("Введите адрес сайта:");
            siteAddress = simpleConsoleInput.scannerInputToString();
            if (siteAddress.equals("")) {
                simpleConsoleOutput.consoleOutput("Вы хотите закончить?");
                simpleConsoleOutput.consoleOutput("Если да, введите 1. Остальное - нет");
                siteAddress = simpleConsoleInput.scannerInputToString();
                if (siteAddress.equals("1")) {
                    isQuit = true;
                }
            } else {
                findSiteInMap(siteAddress);
            }
        } while (!isQuit);
        end();
    }

    static void end() {
        simpleConsoleInput.scannerClose();
    }

    static void findSiteInMap(String site) {
        findSiteInRAM(site);
    }

    static void findSiteInRAM(String site) {
        HashSet<String> temp = cache.get("RAM");
        boolean isSiteInRAM = temp.contains(site);
        if (isSiteInRAM) {
            printFoundRAM();
        } else {
            findSiteInHDD(site);
        }
    }

    static void findSiteInHDD(String site) {
        HashSet<String> temp = cache.get("HDD");
        boolean isSiteInRHDD = temp.contains(site);
        if (isSiteInRHDD) {
            printFoundHDD();
        } else {
            addNewSiteToMap(site);
        }
    }

    static void addNewSiteToMap(String site) {
        printNotFound();
        updateSetInMap("HDD", site);
        updateSetInMap("RAM", site);

    }

    static void updateSetInMap(String key, String site) {
        HashSet<String> temp = cache.get(key);
        temp.add(site);
        cache.put(key, temp);
    }

    static void firstFillMap() {
        firstFillHDDSet();
        putInMap("HDD", hddSet);

        addToSet(ramSet, "advertising.xyz"); //пойманный и пока не удаленный рекламный баннер, с автозагрузкой
        putInMap("RAM", ramSet);
    }

    static void putInMap(String key, HashSet<String> set) {
        cache.put(key, set);
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
        simpleConsoleOutput.consoleOutput("Сайт не найден, ни в RAM, ни на HDD, поэтому загружаем из интернета");
    }

    static void printFoundHDD() {
        simpleConsoleOutput.consoleOutput("Сайт найден на HDD, загружен в RAM и показан быстро");
    }

    static void printFoundRAM() {
        simpleConsoleOutput.consoleOutput("Сайт найден в RAM, и показан моментально");
    }
}
