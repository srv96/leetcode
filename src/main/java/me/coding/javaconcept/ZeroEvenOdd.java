package me.coding.javaconcept;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    Semaphore zeroSemaphore,evenSemaphore,oddSemaphore;
    int current = 1;
    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSemaphore = new Semaphore(1);
        evenSemaphore = new Semaphore(0);
        oddSemaphore = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0); // This calls the IntConsumer's accept method to print the value
            if (current % 2 == 0) {
                evenSemaphore.release();
            } else {
                oddSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(current); // Correctly invoking the consumer
            current++;
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(current); // Correctly invoking the consumer
            current++;
            zeroSemaphore.release();
        }
    }
}
