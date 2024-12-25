package me.coding.company.google;

import java.util.*;

class Solution3 {
    boolean[] visited, pathVisited;
    Map<Integer, Boolean> cycleFlag;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int size = prerequisites.length;
        for (int i = 0; i < size; i++) {
            if (!graph.containsKey(prerequisites[i][1])) {
                graph.put(prerequisites[i][1], new ArrayList<>(List.of(prerequisites[i][0])));
            } else {
                List<Integer> val = graph.get(prerequisites[i][1]);
                val.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], val);
            }
        }
        if (isCyclePresent(graph, numCourses)) return false;
        return true;
    }

    private boolean isCyclePresent(Map<Integer, List<Integer>> graph, int numCourses) {
        visited = new boolean[numCourses];
        pathVisited = new boolean[numCourses];
        cycleFlag = new HashMap<>();
        Arrays.fill(visited, false);
        Arrays.fill(pathVisited, false);
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclePresent(graph, i, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclePresent(Map<Integer, List<Integer>> graph, int i, boolean[] pathVisited) {
        if (!cycleFlag.containsKey(i)) {
            boolean isCycle;
            if (pathVisited[i]) isCycle = true;
            else {
                List<Integer> subOrd = graph.get(i);
                if (subOrd == null) isCycle = false;
                else {
                    isCycle = false;
                    pathVisited[i] = true;
                    for (Integer node : subOrd) {
                        isCycle = isCycle || isCyclePresent(graph, node, pathVisited);
                    }
                    pathVisited[i] = false;
                }
            }
            cycleFlag.put(i, isCycle);
        }
        return cycleFlag.get(i);
    }
}
