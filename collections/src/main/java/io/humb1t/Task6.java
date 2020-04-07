package io.humb1t;

import java.util.concurrent.*;

/*
6. Map is very good in implementation of simple caches). Implement your own cache using Map.
For exemle, is wery simple Exemple:
we put in map some Object, and we take Objects according to a certain sign
*/
public class Task6<K, V> {

/* Признюсь честно, сам кэш никогда не писал и с интерфейсом ScheduledExecutorService не работал, идею подсмотрел,
но максимально упростил. Объект хранится 10 секунд в кэше, потом удаляется. Я так понял весь смысл кэша именно в том,
что через какое-то время он должен самоочищаться.*/

    private volatile ConcurrentHashMap<Key, V> globalMap = new ConcurrentHashMap<Key, V>();
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread th = new Thread(r);
            th.setDaemon(true);
            return th;
        }
    });

    public Task6(long default_timeout) throws Exception {
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long current = System.currentTimeMillis();
                for (Key k : globalMap.keySet()) {
                    if (!k.isLive()) {
                        globalMap.remove(k);
                    }
                }
            }
        }, 1, 5000, TimeUnit.MILLISECONDS);
    }

    public void put(K key, V data) {
        globalMap.put(new Key(key), data);
    }

    public V get(K key) {
        return globalMap.get(new Key(key));
    }

    public void remove(K key) {
        globalMap.remove(new Key(key));
    }

    private static class Key {

        private final Object key;
        private final long timelife = System.currentTimeMillis();

        public Key(Object key) {
            this.key = key;
        }

        public Object getKey() {
            return key;
        }

        public boolean isLive() {
            return timelife + 10000 > System.currentTimeMillis();
        }
    }
}