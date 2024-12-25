package me.coding.company.walmart;

import me.coding.ds.pair.Pair;

import java.util.PriorityQueue;

class Solution14 {
    public int minGroups(int[][] intervals) {
        PriorityQueue<Pair<Integer, Integer>> sortInterval = new PriorityQueue<>((o1, o2) -> {
            if (o1.key == o2.key) {
                return o1.value - o2.value;
            } else {
                return o1.key - o2.key;
            }
        });
        int size = intervals.length;
        for (int i = 0; i < size; i++) {
            sortInterval.add(new Pair<>(intervals[i][0], 0));
            sortInterval.add(new Pair<>(intervals[i][1], 1));
        }
        int interval = 0, maxInterVal = 0;
        while (!sortInterval.isEmpty()) {
            Pair<Integer, Integer> pair = sortInterval.poll();
            if (pair.value == 0) interval++;
            if (pair.value == 1) interval--;
            maxInterVal = Math.max(maxInterVal, interval);
        }
        return maxInterVal;
    }
}
