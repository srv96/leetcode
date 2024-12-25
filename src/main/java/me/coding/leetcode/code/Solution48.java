package me.coding.leetcode.code;

import java.util.*;

class Solution48 {
    public int makeConnected(int n, int[][] connections) {
        int size = connections.length;
        if (size >= n-1) {
            Map<Integer, List<Integer>> graph = getGraph(connections);
            int count = countConnectedComponent(n, graph);
            return count - 1;
        } else return -1;
    }

    private Map<Integer, List<Integer>> getGraph(int[][] connections) {
        int size = connections.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (!graph.containsKey(connections[i][0])) {
                graph.put(connections[i][0], new ArrayList<>(Arrays.asList(connections[i][1])));
            } else {
                List<Integer> conn = graph.get(connections[i][0]);
                conn.add(connections[i][1]);
                graph.put(connections[i][0], conn);
            }
            if (!graph.containsKey(connections[i][1])) {
                graph.put(connections[i][1], new ArrayList<>(Arrays.asList(connections[i][0])));
            } else {
                List<Integer> conn = graph.get(connections[i][1]);
                conn.add(connections[i][0]);
                graph.put(connections[i][1], conn);
            }
        }
        return graph;
    }

    private int countConnectedComponent(int n, Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, visited, graph);
            }
        }
        return count;
    }

    private void bfs(int node, boolean[] visited, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            visited[n] = true;
            List<Integer> conn = graph.get(n);
            if(conn!=null){
                for (Integer c : conn) {
                    if (!visited[c]) {
                        queue.add(c);
                        visited[c] = true;
                    }
                }
            }
        }
    }
}
