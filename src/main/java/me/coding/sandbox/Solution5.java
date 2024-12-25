package me.coding.sandbox;

import me.coding.ds.pair.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Solution5 {
    public int getNumGroup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    findGroup(grid, i, j);
                }
            }
        }
        return count;
    }

    private void findGroup(int[][] grid, int i, int j) {
        Queue<Pair<Integer, Integer>> bfsQueue = new LinkedList<>();
        grid[i][j] = -1;
        bfsQueue.add(new Pair<>(i, j));
        while (!bfsQueue.isEmpty()) {
            Pair<Integer, Integer> pair = bfsQueue.poll();

            if (isExist(pair.key-1, pair.value, grid.length, grid[0].length) && grid[pair.key-1][pair.value] == 1) {
                grid[pair.key-1][pair.value] = -1;
                bfsQueue.add(new Pair<>(pair.key-1, pair.value));
            }
            if (isExist(pair.key, pair.value-1, grid.length, grid[0].length) && grid[pair.key][pair.value-1] == 1){
                grid[pair.key][pair.value-1] = -1;
                bfsQueue.add(new Pair<>(pair.key, pair.value-1));
            }
            if (isExist(pair.key, pair.value+1, grid.length, grid[0].length) && grid[pair.key][pair.value+1] == 1){
                grid[pair.key][pair.value+1] = -1;
                bfsQueue.add(new Pair<>(pair.key, pair.value+1));
            }
            if (isExist(pair.key+1, pair.value, grid.length, grid[0].length) && grid[pair.key+1][pair.value] == 1){
                grid[pair.key+1][pair.value] = -1;
                bfsQueue.add(new Pair<>(pair.key+1, pair.value));
            }
        }
    }

    private boolean isExist(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
