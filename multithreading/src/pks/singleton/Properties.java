package pks.singleton;

/*
Синхронизация полезна только один раз, при первом обращении к getInstance(), после этого каждый раз, при обращении
этому методу, синхронизация просто забирает время, но есть возможность обрабатывать исключительные ситуации
в конструкторе.
 */

public class Properties {
    private static Properties instance;

    private Properties() {
    }

    public static synchronized Properties getInstance() {
        if (instance == null) {
            instance = new Properties();
        }
        return instance;
    }
}
