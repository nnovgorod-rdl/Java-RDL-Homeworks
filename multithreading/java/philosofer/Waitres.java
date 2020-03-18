package philosofer;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class Waitres {
        private final Set<Fork> usedForks = Collections.newSetFromMap(new IdentityHashMap<>());

        void letMeEat(Fork a, Fork b, Runnable eat) {
            synchronized (usedForks) {
                while (usedForks.contains(a) || usedForks.contains(b)) {
                    try {
                        usedForks.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                usedForks.add(a);
                usedForks.add(b);
            }
            synchronized (a) {
                synchronized (b) {
                    eat.run();
                }
            }
            synchronized (usedForks) {
                usedForks.remove(a);
                usedForks.remove(b);
                usedForks.notifyAll();
            }
        }
    }

