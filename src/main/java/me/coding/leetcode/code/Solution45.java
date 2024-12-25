package me.coding.leetcode.code;

import java.util.*;

class Solution45 {
    public Map<Integer, List<Integer>> getGraph(int[][] edges) {
        int size = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
            } else {
                List<Integer> connections = graph.get(edge[0]);
                connections.add(edge[1]);
                graph.put(edge[0], connections);
            }
        }
        return graph;
    }

    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = getGraph(edges);
        if (isCirclePresent(n, graph)) return new ArrayList<>(Arrays.asList(-1));
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, graph, visited, stack);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private boolean isCirclePresent(int n, Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        Arrays.fill(visited, false);
        Arrays.fill(pathVisited, false);
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                if(checkCircle(i,graph,visited,pathVisited))return true;
            }
        }
        return false;
    }

    private boolean checkCircle(int i, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] pathVisited) {
        if(pathVisited[i])return true;
        else{
            pathVisited[i] = true;
            if(graph.containsKey(i)){
                List<Integer> conn = graph.get(i);
                for(Integer j : conn){
                    if(checkCircle(j,graph,visited,pathVisited))return true;
                }
            }
            visited[i] = true;
            pathVisited[i] = false;
            return false;
        }
    }

    private void bfs(int i, Map<Integer, List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        if (visited[i]) return;
        if (!graph.containsKey(i) || graph.get(i).size() == 0) {
            stack.push(i);
            visited[i] = true;
        } else {
            List<Integer> conn = graph.get(i);
            for (int vertex : conn) {
                if (!visited[vertex]) {
                    bfs(vertex, graph, visited, stack);
                }
            }
            stack.push(i);
            visited[i] = true;
        }
    }
}