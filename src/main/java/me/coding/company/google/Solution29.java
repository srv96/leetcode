package me.coding.company.google;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution29 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> dist = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2)) - Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2)) > 0 ? 1 : -1;
            }
        });
        int len = points.length;
        for (int i = 0; i < len; i++) {
            dist.add(points[i]);
        }
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = dist.poll();
        }
        return result;
    }
}
