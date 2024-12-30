package me.coding.javaconcept;

import java.io.*;

class SingleUse implements Serializable {
    private static final long serialVersionUID = 1L;
    private static volatile SingleUse instance;

    private SingleUse() {
    }

    public static SingleUse getInstance() {
        synchronized (SingleUse.class) {
            if (instance == null) {
                instance = new SingleUse();
            }
            return instance;
        }
    }

    public Object readResolve(){
        return instance;
    }
}

public class SerializationInSingleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingleUse instance1 = SingleUse.getInstance();


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleuse.ser"));
        oos.writeObject(instance1);
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleuse.ser"));
        SingleUse instance2 = (SingleUse) ois.readObject();
        ois.close();

        System.out.println("Instance 1 hashCode: " + instance1.hashCode());
        System.out.println("Instance 2 hashCode: " + instance2.hashCode());
        System.out.println("Are both instances same? " + (instance1 == instance2));
    }

}
