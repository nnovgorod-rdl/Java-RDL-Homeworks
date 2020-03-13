package pks.singleton;

/*
Bill Pugh “Initialization on Demand Holder”
объект инициализируется при первом вызове метода getInstance(). Но есть проблема с обработкой исключительных ситуаций
в конструкторе. Так что, если конструктор класса не вызывает опасений создания исключительных ситуаций,
то смело можно использовать этот метод.
 */

public class Settings {
    private Settings() {
    }

    private static class SettingsHolder {
        private final static Settings instance = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.instance;
    }
}
