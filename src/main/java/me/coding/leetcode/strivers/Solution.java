package me.coding.leetcode.strivers;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++) {
            if (color[i] == -1 && !bfs(graph, color, i)) {
                return false;
            }
        }

        return true;
    }

    boolean bfs(int[][] graph, int[] color, int node) {
        Queue<Integer> q = new LinkedList<>();

        color[node] = 0;
        q.offer(node);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nei : graph[cur]) {
                if (color[nei] == color[cur]) {
                    return false;
                }
                if (color[nei] == -1) {
                    color[nei] = 1 - color[cur];
                    q.offer(nei);
                }
            }
        }

        return true;
    }
//    public boolean isBipartite(int[][] graph) {
//        boolean isBip = true;
//        int nodeNum = graph.length;
//        Set<Integer> nodeSet = IntStream.rangeClosed(0, nodeNum - 1).boxed().collect(Collectors.toSet());
//        Queue<Integer> queue = new LinkedList<>();
//        int[] visitedMap = new int[nodeNum];
//        Arrays.fill(visitedMap, -1);
//        queue.offer(0);
//        visitedMap[0] = 0;
//        nodeSet.remove(0);
//        while (!nodeSet.isEmpty()) {
//            if (queue.isEmpty()) {
//                int n = nodeSet.iterator().next();
//                queue.offer(n);
//                visitedMap[n] = 0;
//                nodeSet.remove(n);
//            }
//            while (!queue.isEmpty()) {
//                int node = queue.poll();
//                int color = visitedMap[node];
//                int nCons = graph[node].length;
//                for (int i = 0; i < nCons; i++) {
//                    if (visitedMap[graph[node][i]] == -1) {
//                        visitedMap[graph[node][i]] = color == 0 ? 1 : 0;
//                        queue.offer(graph[node][i]);
//                        nodeSet.remove(graph[node][i]);
//                    } else if (visitedMap[graph[node][i]] != color) continue;
//                    else {
//                        isBip = false;
//                        break;
//                    }
//                }
//                if (!isBip) break;
//            }
//        }
//        return isBip;
//    }

}
