package me.coding.javaconcept;

public class TestZeroEvenOdd {
    public static void main(String[] args) {
        int n = 10; // Change this value to test different inputs
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        // Thread for zero
        Thread threadZero = new Thread(() -> {
            try {
                zeroEvenOdd.zero(value -> System.out.print(value));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Thread for odd
        Thread threadOdd = new Thread(() -> {
            try {
                zeroEvenOdd.odd(value -> System.out.print(value));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Thread for even
        Thread threadEven = new Thread(() -> {
            try {
                zeroEvenOdd.even(value -> System.out.print(value));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start all threads
        threadZero.start();
        threadOdd.start();
        threadEven.start();

        // Wait for threads to finish
        try {
            threadZero.join();
            threadOdd.join();
            threadEven.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
