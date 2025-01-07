package me.coding.sandbox;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class Solution1 {

    public void motherTask() {
        System.out.println("mother task begin");
        Thread childTask = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("child task running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        childTask.setDaemon(true);
        childTask.start();
        try {
            childTask.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("mother task completed");
    }

    public void printEvenOddSequence() {
        Object lock = new Object();
        int[] turn = {0};
        Thread even = new Thread(() -> {
            synchronized (lock) {
                int n = 0;
                for (int i = 0; i < 5; i++) {
                    while (turn[0] != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(2 * n + " ");
                    n++;
                    turn[0] = (turn[0] + 1) % 2;
                    lock.notifyAll();
                }
            }
        });
        Thread odd = new Thread(() -> {
            synchronized (lock) {
                int n = 0;
                for (int i = 0; i < 5; i++) {
                    while (turn[0] != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print((2 * n) + 1 + " ");
                    n++;
                    turn[0] = (turn[0] + 1) % 2;
                    lock.notifyAll();
                }
            }
        });

        even.start();
        odd.start();

    }

    public void semaphoreTest() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        boolean[] done = new boolean[data.length];
        Arrays.fill(done, false);
        Object lock = new Object();
        final int[] n = {0};
        Semaphore semaphore = new Semaphore(2);
        Runnable runnable = () -> {
            while (true) {
                int token;
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock) {
                    if (n[0] < data.length && !done[n[0]]) {
                        token = data[n[0]];
                        n[0]++;
                        done[n[0]] = true;
                    } else {
                        semaphore.release();
                        break;
                    }
                }
                System.out.println("processing token : " + token + " with thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                semaphore.release();
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }

    public void deadLock() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("lock1 accuried in t1 for processing");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("lock2 accuried in t1 for processing");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("lock2 accuried in t2 for processing");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("lock1 accuried in t2 for processing");
                }
            }
        });

        System.out.println("processing start");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("processing end");
    }

    public static void main(String[] args) {
        new Solution1().motherTask();
    }
}
