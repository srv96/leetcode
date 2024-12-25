package me.coding.company.google;

import java.util.*;

class Solution8 {
    Map<Integer, List<Integer>> graph;
    Map<Integer, Integer> memo;
    boolean[] visited, pathVisited;

    public int minimumSemesters(int n, int[][] relations) {
        long startTime = System.nanoTime();
        graph = new HashMap<>();
        memo = new HashMap<>();
        int size = relations.length;
        for (int[] relation : relations) {
            if (!graph.containsKey(relation[0])) {
                graph.put(relation[0], new ArrayList<>(List.of(relation[1])));
            } else {
                List<Integer> conn = graph.get(relation[0]);
                conn.add(relation[1]);
                graph.put(relation[0], conn);
            }
        }
        if (isCyclePresent(n, graph)) return -1;
        for (int i = 1; i <= n; i++) {
            getLongest(i, graph);
        }
        int result = Integer.MIN_VALUE;
        for (Integer key : memo.keySet()) {
            result = Math.max(result, memo.get(key));
        }
        return result;
    }

    private boolean isCyclePresent(int n, Map<Integer, List<Integer>> graph) {
        visited = new boolean[n + 1];
        pathVisited = new boolean[n + 1];
        Arrays.fill(visited, false);
        Arrays.fill(pathVisited, false);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (cycle(i, graph)) return true;
            }
        }
        return false;
    }

    private boolean cycle(int i, Map<Integer, List<Integer>> graph) {
        if (pathVisited[i]) return true;
        if (visited[i]) return false;
        if (!graph.containsKey(i)) {
            visited[i] = true;
            return false;
        } else {
            visited[i] = true;
            pathVisited[i] = true;
            List<Integer> conn = graph.get(i);
            for (Integer node : conn) {
                if (cycle(node, graph)) return true;
            }
            pathVisited[i] = false;
            return false;
        }
    }

    private int getLongest(int i, Map<Integer, List<Integer>> graph) {
        if (!memo.containsKey(i)) {
            if (!graph.containsKey(i)) {
                memo.put(i, 1);
            } else {
                int max = Integer.MIN_VALUE;
                List<Integer> conn = graph.get(i);
                for (Integer node : conn) {
                    max = Math.max(max, getLongest(node, graph));
                }
                memo.put(i, max + 1);
            }
        }
        return memo.get(i);
    }
}
