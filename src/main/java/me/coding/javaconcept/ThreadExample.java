package me.coding.javaconcept;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code for thread 1
                System.out.println("Thread 1 is running.");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Code for thread 2
                System.out.println("Thread 2 is running.");
            }
        });

        thread1.start(); // Start thread 1
        try {
            thread1.join(); // Wait for thread 1 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start(); // Start thread 2 after thread 1 completes
    }
}

