package me.coding.company.google;

import me.coding.ds.pair.Pair;

import java.util.LinkedList;
import java.util.Queue;

class RLEIterator {
    int freq, val;
    Queue<Pair<Integer, Integer>> freqValQueue;

    public RLEIterator(int[] encoding) {
        int size = encoding.length;
        freqValQueue = new LinkedList<>();
        for (int i = 0; i < size; i += 2) {
            freqValQueue.add(new Pair<>(encoding[i], encoding[i + 1]));
        }
        Pair<Integer, Integer> pair = freqValQueue.poll();
        this.freq = pair.key;
        this.val = pair.value;
    }

    public int next(int n) {
        while (n > this.freq && !freqValQueue.isEmpty()) {
            n -= this.freq;
            Pair<Integer, Integer> pair = freqValQueue.poll();
            this.freq = pair.key;
            this.val = pair.value;
        }
        if (n > this.freq) {
            this.freq = -1;
            this.val = -1;
            return -1;
        } else {
            this.freq -= n;
            return this.val;
        }
    }
}
