package ThreadSafeSingleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
/*
Not Lazy load
        1.Static field
        + Простая и прозрачная реализация
        + Потокобезопасность
        2.Enum Singleton
        + Остроумно
        + Сериализация из коробки
        + Потокобезопасность из коробки
        + Возможность использования EnumSet, EnumMap и т.д.
        + Поддержка switch
Lazy load
        1 Synchronized Accessor
        - Низкая производительность (критическая секция) в наиболее типичном доступе
        2 Double Checked Locking & volatile
        + Высокая производительность
        - Поддерживается только с JDK 1.5 [5]
        3 On Demand Holder idiom
        + Высокая производительность
        - Невозможно использовать для не статических полей класса
       In my programing experience, i worked with Singeltone only once. When i made java EE application, and classes DAO
       was Singleton. And i made it with static field. Therefore it my favorite way to make Singleton.
       It is wery fast and simple!
       Plus and minus of others methods described above!
*/