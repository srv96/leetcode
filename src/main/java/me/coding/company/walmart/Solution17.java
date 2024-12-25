package me.coding.company.walmart;

import me.coding.ds.pair.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution17 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        int size = intervals.length;
        for (int i = 0; i < size; i++) {
            pq.add(new Pair<>(intervals[i][0], intervals[i][1]));
        }
        Pair<Integer, Integer> pair = pq.poll();
        int end = pair.value;
        int remove = 0;
        while (!pq.isEmpty()) {
            pair = pq.poll();
            if (pair.key < end) {
                remove++;
            } else {
                end = pair.value;
            }
        }
        return remove;
    }
}