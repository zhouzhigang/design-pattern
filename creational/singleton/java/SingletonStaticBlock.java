/**
 * Singleton - Static block initialization.
 *
 * advantages:
 *
 * Reference:
 * <a href="http://en.wikipedia.org/wiki/Singleton_pattern#Static_block_initialization">Static block initialization</a>
 *
 */
public class SingletonStaticBlock {
    /**
     * Private constructor. Prevents instantiation from other classes by new.
     */
    private SingletonStaticBlock() {
    }

    private static final SingletonStaticBlock INSTANCE;

    static {
        try {
            INSTANCE = new SingletonStaticBlock();
        } catch (Exception e) {
            throw new RuntimeException("Darn, an error occurred!", e);
        }
    }

    /**
     * The interface for user to get the sington instance.
     * @return sington instance
     */
    public static SingletonStaticBlock getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        SingletonStaticBlock instance1 = SingletonStaticBlock.getInstance();
        SingletonStaticBlock instance2 = SingletonStaticBlock.getInstance();
        System.out.println(instance1 == instance2);
    }
}