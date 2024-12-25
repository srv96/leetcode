package me.coding.javaconcept;

public class Concurrent {
    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread th1 = new Thread(runnable1, "thread 1");
        Runnable runnable2 = () -> {
            try {
                th1.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread th2 = new Thread(runnable2, "thread 2");

        th1.start();
        th2.start();
    }
}
