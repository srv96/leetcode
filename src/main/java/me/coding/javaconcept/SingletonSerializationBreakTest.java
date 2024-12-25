package me.coding.javaconcept;

import java.io.*;

class Singleton implements Serializable {
    private static final long serialVersionUID = 1L;

    // Static instance of the Singleton
    private static final Singleton instance = new Singleton();

    // Private constructor to prevent instantiation
    private Singleton() {}

    // Public method to provide the single instance
    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton1 implements Serializable {
    private static final long serialVersionUID = 1L;

    // Volatile ensures thread-safety for lazy initialization
    private static volatile Singleton1 instance;

    // Private constructor to prevent instantiation
    private Singleton1() {
        if (instance != null) {
            throw new IllegalStateException("Instance already exists");
        }
    }

    // Public method to provide the single instance
    public static Singleton1 getInstance() {
        if (instance == null) {
            synchronized (Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }

    // readResolve method to prevent creation of new instance during deserialization
    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}

public class SingletonSerializationBreakTest {
    public static void main(String[] args) {
        try {
            Singleton instance1 = Singleton.getInstance();

            // Serialize the Singleton instance to a file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            oos.writeObject(instance1);
            oos.close();

            // Deserialize the Singleton instance from the file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
            Singleton instance2 = (Singleton) ois.readObject();
            ois.close();

            // Verify that both instances are different
            System.out.println("Instance 1 hashCode: " + instance1.hashCode());
            System.out.println("Instance 2 hashCode: " + instance2.hashCode());
            System.out.println("Are both instances same? " + (instance1 == instance2));


            Singleton1 instance3 = Singleton1.getInstance();

            // Serialize the Singleton instance to a file
            ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("singleton1.ser"));
            oos1.writeObject(instance3);
            oos1.close();

            // Deserialize the Singleton instance from the file
            ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("singleton1.ser"));
            Singleton1 instance4 = (Singleton1) ois1.readObject();
            ois1.close();

            // Verify that both instances are different
            System.out.println("\nInstance 3 hashCode: " + instance3.hashCode());
            System.out.println("Instance 4 hashCode: " + instance4.hashCode());
            System.out.println("Are both instances same? " + (instance3 == instance4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

