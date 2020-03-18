package io.humb1t;

import java.util.Optional;
import java.util.concurrent.*;


public class NewCache<K, V> {

    private volatile ConcurrentHashMap<Key, V> globalMap = new ConcurrentHashMap<Key, V>();
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread th = new Thread(r);
            th.setDaemon(true);
            return th;
        }
    });

    public NewCache(long default_timeout) throws Exception {
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

    public Optional<V> get(K key) {
        return Optional.of(globalMap.get(new Key(key)));
    }
    //API and Optional
    /*I think, that isn't justified, because it is not important what we return Null or Option. By the way,
     programmer who will be work with our code, may be old school coder or beginner. and he wouldnt understand
     our feature with Option  */

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