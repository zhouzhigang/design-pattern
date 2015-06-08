/**
 * Singleton - The enum way.
 *
 * Joshua Bloch claims that "a single-element enum type is the best way to implement a singleton" for any Java that supports enums.
 * Since Java enum values are globally accessible, so is the singleton, initialized lazily by the class loader.
 *
 * advantages:
 *  The use of an enum is very easy to implement and has no drawbacks regarding serializable objects, which have to be circumvented in the other ways.
 *  Java's guarantee that any enum value is instantiated only once in a Java program.
 *
 * The drawback is that the enum type is somewhat inflexible.
 *
 * Reference:
 * <a href="http://en.wikipedia.org/wiki/Singleton_pattern#Static_block_initialization">Static block initialization</a>
 *
 */
public enum SingletonEnum {
    INSTANCE;

    /**
     * The public method can be written to take any desired types of arguments.
     */
    public String greeting() {
        return "hello";
    }
    public static void main(String[] args) {
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println(instance1 == instance2);
        System.out.println(instance1.greeting());
    }

}
/*
public final class SingletonEnum extends Enum
{
    public static final SingletonEnum INSTANCE;
    private static final SingletonEnum $VALUES[];

    static
    {
        INSTANCE = new SingletonEnum("INSTANCE", 0);
        $VALUES = (new SingletonEnum[] {
            INSTANCE
        });
    }

    public static SingletonEnum[] values()
    {
        return (SingletonEnum[])$VALUES.clone();
    }

    public static SingletonEnum valueOf(String s)
    {
        return (SingletonEnum)Enum.valueOf(SingletonEnum, s);
    }

    private SingletonEnum(String s, int i)
    {
        super(s, i);
    }
}
 */