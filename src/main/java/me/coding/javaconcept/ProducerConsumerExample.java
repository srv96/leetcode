package me.coding.javaconcept;

import java.util.concurrent.Semaphore;

class Buffer {
    private int[] items;
    private int size;
    private int in, out;
    private Semaphore mutex, empty, full;

    public Buffer(int capacity) {
        size = capacity;
        items = new int[size];
        in = 0;
        out = 0;
        mutex = new Semaphore(1);
        empty = new Semaphore(size);
        full = new Semaphore(0);
    }

    public void produce(int item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        items[in] = item;
        in = (in + 1) % size;
        System.out.println("Produced: " + item);
        mutex.release();
        full.release();
    }

    public int consume() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        int item = items[out];
        out = (out + 1) % size;
        System.out.println("Consumed: " + item);
        mutex.release();
        empty.release();
        return item;
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                int item = buffer.consume();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Producer-Consumer example completed.");
    }
}
