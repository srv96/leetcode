package me.coding.javaconcept;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final Semaphore semaphore = new Semaphore(0); // Allow 2 threads to access at a time

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(new Task(i, semaphore));
            t.start();
        }
    }
}

class Task implements Runnable {
    private int threadId;
    private Semaphore semaphore;

    public Task(int threadId, Semaphore semaphore) {
        this.threadId = threadId;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread-" + threadId + " is waiting for a permit.");
            semaphore.acquire(); // Acquire a permit
            System.out.println("Thread-" + threadId + " got a permit.");

            // Simulate work with the shared resource
            Thread.sleep(2000);

            System.out.println("Thread-" + threadId + " is releasing the permit.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}
