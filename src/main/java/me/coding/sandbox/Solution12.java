package me.coding.sandbox;

import java.util.concurrent.Semaphore;

public class Solution12 {
    public static void main(String[] args) {
        int[] num = {1, 34, 5, 7, 5, 43, 5, 7, 4, 32, 5, 78, 8, 5, 4, 6, 78, 4, 6, 78, 6, 4, 3, 34, 5, 7, 78, 5, 4, 6, 78, 8, 56, 5, 76, 7, 5, 5, 76, 6, 5, 4, 6, 5};
        boolean[] processed  = new boolean[num.length];
        Semaphore semaphore = new Semaphore(2);
        Object lock = new Object();
        Thread t1 = new Thread(() -> {

        });
    }
}
