package me.coding.leetcode.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution22 {
    private static int[][] convertToAdjacencyMatrix(int[][] edgeList, int numNodes) {
        int[][] adjacencyMatrix = new int[numNodes+1][numNodes+1];
        for (int[] edge : edgeList) {
            adjacencyMatrix[edge[0]][edge[1]] = 1;
            adjacencyMatrix[edge[1]][edge[0]] = 1;
        }
        return adjacencyMatrix;
    }

    private static int checkUnvisited(int[] array) {
        for (int i = 0; i < array.length; i++) if (array[i] == -1) return i;
        return -1;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Arrays.sort(dislikes, Comparator.comparingInt((int[] row) -> row[0]).thenComparingInt(row -> row[1]));
        int color[] = new int[n + 1];
        Arrays.fill(color, -1);
        color[0]=1;
        int[][] adjMatrix = convertToAdjacencyMatrix(dislikes, n);
        Queue<Integer> queue = new LinkedList<>();
        while (checkUnvisited(color) != -1) {
            int start = checkUnvisited(color);
            color[start] = 0;
            queue.offer(start);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                int clr = color[node];
                for (int i = 1; i <= n; i++) {
                    if(i==node)continue;
                    if(adjMatrix[node][i]==1){
                        if(clr == color[i])return false;
                        if(color[i] ==-1){
                            color[i] = clr == 0 ? 1 : 0 ;
                            queue.offer(i);
                        }
                    }
                }
            }
        }
        for(int[] edge : dislikes){
            if(color[edge[0]]==color[edge[1]])return false;
        }
        return true;
    }
}
