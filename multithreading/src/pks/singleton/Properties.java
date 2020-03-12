package pks.singleton;

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
