package me.coding.javaconcept;

public class VolatileExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        // Thread 1: Writer Thread
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some work
                flag = true;
                System.out.println("Writer: Flag set to true");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Thread 2: Reader Thread
        Thread reader = new Thread(() -> {
            while (!flag) {
                // Busy-waiting for the flag to become true
            }
            System.out.println("Reader: Detected flag change");
        });

        writer.start();
        reader.start();
    }
}

