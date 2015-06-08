import java.lang.reflect.Constructor;

/**
 * Using Reflection to destroy Singleton Pattern excep for Enum way.
 * Reflection can be used to destroy all the most singleton implementation approaches.
 *
 * Reference:
 * <a href="http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples#reflection-and-singleton">Using Reflection to destroy Singleton Pattern</a>
 */
public class SingletonReflection {
    public static SingletonEager getInstanceByReflection() {
        SingletonEager instance = null;
        try {
            Constructor[] constructors = SingletonEager.class.getDeclaredConstructors();
            for (Constructor constructor: constructors) {
                constructor.setAccessible(true);
                instance = (SingletonEager) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
    public static void main(String[] args) {
        SingletonEager instance1 = SingletonEager.getInstance();
        SingletonEager instance2 = getInstanceByReflection();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}