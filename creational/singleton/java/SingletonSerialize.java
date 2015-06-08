import java.io.Serializable;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Serialization and Singleton.
 * Sometimes in distributed systems, we need to implement Serializable interface in Singleton class
 * so that we can store it’s state in file system and retrieve it at later point of time.
 *
 * The problem with serialized singleton class is that whenever we deserialize it, it will create a new instance of the class.
 * To overcome this scenario all we need to do it provide the implementation of readResolve() method.
 *
 * Reference:
 * <a href="http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples#serialization-and-singleton">Serialization and Singleton</a>
 */
public class SingletonSerialize implements Serializable {
     private static final long serialVersionUID = -7604766932017737115L;

    /**
     * Private constructor. Prevents instantiation from other classes by new.
     */
    private SingletonSerialize() {
    }

    /**
     * SingletonHolder is loaded on the first execution of SingletonSerialize.getInstance(),
     * or the first access to SingletonHolder.INSTANCE, not before.
     */
    private static class SingletonHolder {
        private static final SingletonSerialize INSTACNE = new SingletonSerialize();
    }

    /**
     * The interface for user to get the sington instance.
     * @return sington instance
     */
    public static synchronized SingletonSerialize getInstance() {
        return SingletonHolder.INSTACNE;
    }

    /**
     * provide the implementation of readResolve() method to avoid destroys the singleton pattern by serialize and deserialize.
     * @return [description]
     */
    protected Object readResolve() {
        return getInstance();
    }

    public static void serializeInstance() throws FileNotFoundException, IOException{
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(SingletonSerialize.getInstance());
        out.close();
    }
    public static SingletonSerialize deserializeInstance() throws FileNotFoundException, IOException, ClassNotFoundException {
        SingletonSerialize instance = null;
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        instance = (SingletonSerialize) in.readObject();
        in.close();
        return instance;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SingletonSerialize instance1 = SingletonSerialize.getInstance();
        serializeInstance();
        SingletonSerialize instance2 = SingletonSerialize.deserializeInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}