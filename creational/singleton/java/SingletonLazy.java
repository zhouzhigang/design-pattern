/**
 * Singleton - Lazy initialization.
 * An alternate simpler and cleaner version may be used at the expense of potentially lower concurrency in a multithreaded environment.
 *
 * advantages:
 *
 * Reference:
 * <a href="http://en.wikipedia.org/wiki/Singleton_pattern#Lazy_initialization">Lazy initialization</a>
 *
 */
public class SingletonLazy {
    /**
     * Private constructor. Prevents instantiation from other classes by new.
     */
    private SingletonLazy() {
    }

    private static SingletonLazy instance = null;

    /**
     * The interface for user to get the sington instance.
     * @return sington instance
     */
    public static synchronized SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonLazy instance1 = SingletonLazy.getInstance();
        SingletonLazy instance2 = SingletonLazy.getInstance();
        System.out.println(instance1 == instance2);
    }
}