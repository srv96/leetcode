package me.coding.javaconcept;

import java.util.concurrent.Semaphore;

class SharedSemaphore {
    private Semaphore semaphore = new Semaphore(0);

    public void waitForSecondRunnable() throws InterruptedException {
        semaphore.acquire();
    }

    public void notifySecondRunnableStarted() {
        semaphore.release();
    }
}

class FirstRunnable implements Runnable {
    private final SharedSemaphore sharedSemaphore;

    public FirstRunnable(SharedSemaphore sharedSemaphore) {
        this.sharedSemaphore = sharedSemaphore;
    }

    @Override
    public void run() {
        System.out.println("FirstRunnable is starting.");
        // Simulate some work
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FirstRunnable is waiting for SecondRunnable.");
        try {
            sharedSemaphore.waitForSecondRunnable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FirstRunnable is resuming and completing.");
    }
}

class SecondRunnable implements Runnable {
    private final SharedSemaphore sharedSemaphore;

    public SecondRunnable(SharedSemaphore sharedSemaphore) {
        this.sharedSemaphore = sharedSemaphore;
    }

    @Override
    public void run() {
        System.out.println("SecondRunnable is starting.");
        // Simulate some work
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SecondRunnable is completing.");
        sharedSemaphore.notifySecondRunnableStarted();
    }
}

public class ThreadProgram {
    public static void main(String[] args) {
        SharedSemaphore sharedSemaphore = new SharedSemaphore();

        Thread thread1 = new Thread(new FirstRunnable(sharedSemaphore));
        Thread thread2 = new Thread(new SecondRunnable(sharedSemaphore));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have completed.");
    }
}

