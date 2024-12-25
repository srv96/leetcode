package me.coding.javaconcept;

import java.util.ArrayList;
import java.util.List;

public class DynamicThreadCommunication {

    public static List<Thread> createThreads(int numThreads, int max) {
        Object lock = new Object();
        int[] turn = {0}; // Shared state to track the current thread's turn
        List<Thread> threads = new ArrayList<>();

        for (int threadIndex = 0; threadIndex < numThreads; threadIndex++) {
            int currentIndex = threadIndex; // Capture the thread index for use in lambda
            threads.add(new Thread(() -> {
                synchronized (lock) {
                    for (int i = 0; i <= max; i++) {
                        while (turn[0] != currentIndex) {
                            try {
                                lock.wait(); // Wait until it's this thread's turn
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        System.out.print((numThreads * i + currentIndex) + " "); // Print based on formula
                        turn[0] = (turn[0] + 1) % numThreads; // Pass turn to the next thread
                        lock.notifyAll(); // Notify all threads
                    }
                }
            }));
        }

        return threads;
    }

    public static void main(String[] args) {
        int numThreads = 10; // Number of threads
        int max = 10; // Maximum value for 'i'

        List<Thread> threads = createThreads(numThreads, max);

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



