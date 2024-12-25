package me.coding.company.google;

import java.util.*;

class Solution1 {
    public double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public int maximumDetonation(int[][] bombs) {
        Map<Integer, Set<Integer>> connection = new HashMap<>();
        int size = bombs.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j && getDistance(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]) <= bombs[i][2]) {
                    if (!connection.containsKey(i)) {
                        Set<Integer> vals = new HashSet<>();
                        vals.add(j);
                        connection.put(i, vals);
                    } else {
                        Set<Integer> vals = connection.get(i);
                        vals.add(j);
                        connection.put(i, vals);
                    }
                }
            }
        }
        Queue<Integer> explosions = new LinkedList<>();
        int maxBlast = 0;
        for (int i = 0; i < size; i++) {
            explosions.add(i);
            int count = 0;
            boolean[] blasted = new boolean[size];
            Arrays.fill(blasted, false);
            blasted[i] = true;
            while (!explosions.isEmpty()) {
                int bomb = explosions.poll();
                count++;
                if (connection.get(bomb) != null && connection.get(bomb).size() > 0) {
                    for (Integer point : connection.get(bomb)) {
                        if (!blasted[point]) {
                            blasted[point] = true;
                            explosions.add(point);
                        }
                    }
                }
            }
            maxBlast = Math.max(maxBlast, count);
        }
        return maxBlast;
    }
}

