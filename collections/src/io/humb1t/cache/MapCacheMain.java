package io.humb1t.cache;

import io.humb1t.cache.console.SimpleConsoleInput;
import io.humb1t.cache.console.SimpleConsoleOutput;

import java.util.HashMap;

public class MapCacheMain {
    static SimpleConsoleInput simpleConsoleInput = new SimpleConsoleInput();
    static SimpleConsoleOutput simpleConsoleOutput = new SimpleConsoleOutput();

    static final HashMap<String, CacheEnum> cacheMap = new HashMap<>();
    static String siteAddress = "";

    static boolean isQuit = false;
    static boolean isFirstRun = true;

    enum CacheEnum {HDD, RAM}

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
        CacheEnum location = cacheMap.get(site);
        if (location == null) {
            printNotFound();
            //И сразу сайт в RAM
            addToMap(site, CacheEnum.RAM);
        } else if (location == CacheEnum.RAM) {
            printFoundRAM();
        } else {
            printFoundHDD();
            //Перекладываем сайт в RAM
            updateSiteInMap(site, CacheEnum.RAM);
        }
    }

    static void firstFillMap() {
        addToMap("yandex.ru", CacheEnum.HDD);
        addToMap("training.ru", CacheEnum.HDD);
        addToMap("learn.by", CacheEnum.HDD);
        addToMap("google.com", CacheEnum.HDD);
        addToMap("stackoverflow.com", CacheEnum.HDD);
        addToMap("ad.xyz", CacheEnum.RAM);//пойманный и пока не удаленный рекламный баннер, с автозагрузкой
    }

    static void addToMap(String site, CacheEnum cache) {
        cacheMap.put(site, cache);
    }

    static void updateSiteInMap(String site, CacheEnum cache) {
        cacheMap.replace(site, cache);
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
