package me.coding.company.adobe;

import java.util.*;

class Solution2 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        Arrays.fill(degree, 0);
        int size = roads.length;
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < size; i++) {
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
            if (!graph.containsKey(roads[i][0])) {
                graph.put(roads[i][0], new ArrayList<>(List.of(roads[i][1])));
            } else {
                ArrayList<Integer> vals = graph.get(roads[i][0]);
                vals.add(roads[i][1]);
                graph.put(roads[i][0], vals);
            }
            if (!graph.containsKey(roads[i][1])) {
                graph.put(roads[i][1], new ArrayList<>(List.of(roads[i][0])));
            } else {
                ArrayList<Integer> vals = graph.get(roads[i][1]);
                vals.add(roads[i][0]);
                graph.put(roads[i][1], vals);
            }
        }
        int maxRank = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n && j != i; j++) {
                int rank = degree[i] + degree[j];
                if (graph.get(i) != null && graph.get(i).contains(j)) rank--;
                maxRank = Math.max(maxRank, rank);
            }
        }
        return maxRank;
    }
}
