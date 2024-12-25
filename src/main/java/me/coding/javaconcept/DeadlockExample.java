package me.coding.javaconcept;

public class DeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " locked lock1");
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " locked lock2");
                }
            }
        }, "Thread A");

        Thread threadB = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " locked lock2");
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " locked lock1");
                }
            }
        }, "Thread B");

        threadA.start();
        threadB.start();
    }
}
