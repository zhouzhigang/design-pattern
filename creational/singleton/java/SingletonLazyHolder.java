/**
 * Singleton - Initialization-on-demand holder idiom.
 * works in all known versions of Java.
 *
 * advantages:
 *  The nested class is referenced no earlier (and therefore loaded no earlier by the class loader) than the moment that getInstance() is called.
 *  thread-safe without requiring special language constructs (i.e. volatile or synchronized).
 *
 * Alternatively, the inner class SingletonHolder can also be substituted by implementing a Property which provides also access to the static final/read-only class members.
 * Just like the lazy object in C#, whenever the SingletonLazyHolder.INSTANCE property is called, this singleton is instantiated for the very first time.
 *
 * Reference:
 * <a href="http://en.wikipedia.org/wiki/Singleton_pattern#Initialization-on-demand_holder_idiom">Initialization-on-demand holder idiom</a>
 *
 */
public class SingletonLazyHolder {
    /**
     * Private constructor. Prevents instantiation from other classes by new.
     */
    private SingletonLazyHolder() {
    }

    /**
     * SingletonHolder is loaded on the first execution of SingletonLazyHolder.getInstance(),
     * or the first access to SingletonHolder.INSTANCE, not before.
     */
    private static class SingletonHolder {
        private static final SingletonLazyHolder INSTACNE = new SingletonLazyHolder();
    }

    /**
     * The interface for user to get the sington instance.
     * @return sington instance
     */
    public static synchronized SingletonLazyHolder getInstance() {
        return SingletonHolder.INSTACNE;
    }

    public static void main(String[] args) {
        SingletonLazyHolder instance1 = SingletonLazyHolder.getInstance();
        SingletonLazyHolder instance2 = SingletonLazyHolder.getInstance();
        System.out.println(instance1 == instance2);
    }
}