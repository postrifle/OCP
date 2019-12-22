package OCP8.misc.designpatterns;

public class LazyInitializationSingletonExample {
    private static LazyInitializationSingletonExample instance;

    private LazyInitializationSingletonExample() {
    }

    public synchronized static LazyInitializationSingletonExample getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingletonExample();
        }
        return instance;
    }

    //    singleton with double-checked locking, in which it is tested if synchronization is needed
    public static LazyInitializationSingletonExample getLazyInitSingletonInstance() {
        if (instance == null) {
            synchronized (LazyInitializationSingletonExample.class) {
                if (instance == null) {
                    instance = new LazyInitializationSingletonExample();
                }
            }
        }
        return instance;
    }

}
