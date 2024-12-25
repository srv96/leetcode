package me.coding.javaconcept;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock(); // Create a ReentrantLock
    private static int counter = 0; // Shared resource

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> incrementCounter("Thread-1"));
        Thread t2 = new Thread(() -> incrementCounter("Thread-2"));
        Thread t3 = new Thread(() -> incrementCounter("Thread-3"));
        Thread t4 = new Thread(() -> incrementCounter("Thread-4"));
        Thread t5 = new Thread(() -> incrementCounter("Thread-5"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    private static void incrementCounter(String threadName) {
        for (int i = 0; i < 5; i++) {
            lock.lock(); // Acquire the lock
            System.out.println(threadName + " has acquired the lock.");
            counter++;
            System.out.println(threadName + " incremented counter to: " + counter);
            System.out.println(threadName + " is releasing the lock.");
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            try {
                Thread.sleep(10); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

