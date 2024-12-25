package me.coding.company.flipkart;

import me.coding.ds.pair.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public int shortestBridge(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Pair<Integer, Integer>> island = new LinkedList<>();
        boolean[][] visitGrid = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(visitGrid[i], false);
        }
        for (int i = 0; i < row; i++) {
            boolean oBreak = false;
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    getIsland(grid, visitGrid, island, i, j, row, col);
                    oBreak = true;
                    break;
                }
            }
            if (oBreak) break;
        }
        expand(grid, visitGrid, island, row, col);
        int minBridge = findMinBridge(grid, visitGrid, row, col);
        return minBridge - 1;
    }

    private int findMinBridge(int[][] grid, boolean[][] visitGrid, int row, int col) {
        int minBridge = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visitGrid[i][j]) {
                    int top = !isExist(i - 1, j, row, col) || grid[i - 1][j] == 1 || grid[i - 1][j] == 0 ? Integer.MAX_VALUE : Math.abs(grid[i - 1][j]);
                    int left = !isExist(i, j - 1, row, col) || grid[i][j - 1] == 1 || grid[i][j - 1] == 0 ? Integer.MAX_VALUE : Math.abs(grid[i][j - 1]);
                    int right = !isExist(i, j + 1, row, col) || grid[i][j + 1] == 1 || grid[i][j + 1] == 0 ? Integer.MAX_VALUE : Math.abs(grid[i][j + 1]);
                    int bottom = !isExist(i + 1, j, row, col) || grid[i + 1][j] == 1 || grid[i + 1][j] == 0 ? Integer.MAX_VALUE : Math.abs(grid[i + 1][j]);
                    int localMin = Math.min(Math.min(top, bottom), Math.min(left, right));
                    minBridge = Math.min(minBridge, localMin);
                }
            }
        }
        return minBridge;
    }

    private void expand(int[][] grid, boolean[][] visitGrid, Queue<Pair<Integer, Integer>> island, int row, int col) {
        while (!island.isEmpty()) {
            Pair<Integer, Integer> pair = island.poll();
            if (isExist(pair.key - 1, pair.value, row, col))
                if (!visitGrid[pair.key - 1][pair.value] && grid[pair.key - 1][pair.value] != 1) {
                    visitGrid[pair.key - 1][pair.value] = true;
                    grid[pair.key - 1][pair.value] = grid[pair.key][pair.value] - 1;
                    island.add(new Pair<>(pair.key - 1, pair.value));
                }
            if (isExist(pair.key, pair.value - 1, row, col))
                if (!visitGrid[pair.key][pair.value - 1] && grid[pair.key][pair.value - 1] != 1) {
                    visitGrid[pair.key][pair.value - 1] = true;
                    grid[pair.key][pair.value - 1] = grid[pair.key][pair.value] - 1;
                    island.add(new Pair<>(pair.key, pair.value - 1));
                }
            if (isExist(pair.key, pair.value + 1, row, col))
                if (!visitGrid[pair.key][pair.value + 1] && grid[pair.key][pair.value + 1] != 1) {
                    visitGrid[pair.key][pair.value + 1] = true;
                    grid[pair.key][pair.value + 1] = grid[pair.key][pair.value] - 1;
                    island.add(new Pair<>(pair.key, pair.value + 1));
                }
            if (isExist(pair.key + 1, pair.value, row, col))
                if (!visitGrid[pair.key + 1][pair.value] && grid[pair.key + 1][pair.value] != 1) {
                    visitGrid[pair.key + 1][pair.value] = true;
                    grid[pair.key + 1][pair.value] = grid[pair.key][pair.value] - 1;
                    island.add(new Pair<>(pair.key + 1, pair.value));
                }
        }
    }

    private boolean isExist(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    private void getIsland(int[][] grid, boolean[][] visitGrid, Queue<Pair<Integer, Integer>> island, int i, int j, int row, int col) {
        island.add(new Pair<>(i, j));
        visitGrid[i][j] = true;
        grid[i][j] = -1;
        if (isExist(i - 1, j, row, col))
            if (!visitGrid[i - 1][j] && grid[i - 1][j] == 1) getIsland(grid, visitGrid, island, i - 1, j, row, col);
        if (isExist(i, j - 1, row, col))
            if (!visitGrid[i][j - 1] && grid[i][j - 1] == 1) getIsland(grid, visitGrid, island, i, j - 1, row, col);
        if (isExist(i, j + 1, row, col))
            if (!visitGrid[i][j + 1] && grid[i][j + 1] == 1) getIsland(grid, visitGrid, island, i, j + 1, row, col);
        if (isExist(i + 1, j, row, col))
            if (!visitGrid[i + 1][j] && grid[i + 1][j] == 1) getIsland(grid, visitGrid, island, i + 1, j, row, col);

    }
}
