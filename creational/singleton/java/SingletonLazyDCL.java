/**
 * Singleton - Lazy initialization with double-checked locking.
 * should not be used prior to J2SE 5.0, as it is vulnerable to subtle bugs.
 *
 * advantages:
 *
 * Reference:
 * <a href="http://en.wikipedia.org/wiki/Singleton_pattern#Lazy_initialization">Lazy initialization</a>
 *
 */
public class SingletonLazyDCL {
    /**
     * Private constructor. Prevents instantiation from other classes by new.
     */
    private SingletonLazyDCL() {
    }

    private static volatile SingletonLazyDCL instance = null;

    /**
     * The interface for user to get the sington instance.
     * @return sington instance
     */
    public static SingletonLazyDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyDCL.class) {
                if (instance == null) {
                    instance = new SingletonLazyDCL();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonLazyDCL instance1 = SingletonLazyDCL.getInstance();
        SingletonLazyDCL instance2 = SingletonLazyDCL.getInstance();
        System.out.println(instance1 == instance2);
    }
}