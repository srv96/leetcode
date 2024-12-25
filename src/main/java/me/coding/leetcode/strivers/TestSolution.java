package me.coding.leetcode.strivers;

import java.util.List;

public class TestSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2},{5,6},{4,6},{4,5}};
        boolean result = s.isBipartite(graph);
        System.out.println(result);
    }
}
