package pks.singleton;

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
