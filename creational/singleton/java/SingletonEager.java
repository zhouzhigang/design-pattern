/**
 * Singleton - Eager initialization.
 *
 * advantages:
 *  The static initializer is run when the class is initialized, after class loading but before the class is used by any thread.
 *  There is no need to synchronize the getInstance() method, meaning all threads will see the same instance and no (expensive) locking is required.
 *  The final keyword means that the instance cannot be redefined, ensuring that one (and only one) instance ever exists.
 *
 * If the program will always need an instance,
 * or if the cost of creating the instance is not too large in terms of time/resources,
 * the programmer can switch to eager initialization, which always creates an instance.
 *
 * Reference:
 * <a href="http://en.wikipedia.org/wiki/Singleton_pattern#Eager_initialization">Eager initialization</a>
 *
 */
public class SingletonEager {
    /**
     * Private constructor. Prevents instantiation from other classes by new.
     */
    private SingletonEager() {
    }
    /**
     * Initialize the instance at first.
     */
    private static final SingletonEager INSTANCE = new SingletonEager();

    /**
     * The interface for user to get the sington instance.
     * @return sington instance
     */
    public static SingletonEager getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        SingletonEager instance1 = SingletonEager.getInstance();
        SingletonEager instance2 = SingletonEager.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}