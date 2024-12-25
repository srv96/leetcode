package me.coding.leetcode.top150;

import java.util.Arrays;

class Solution32 {
    public int numIslands(char[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rowNum][colNum];
        Arrays.stream(visited).forEach(row -> Arrays.fill(row, false));
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                count += countIsland(i, j, rowNum, colNum, grid, visited);
            }
        }
        return count;
    }

    private int countIsland(int i, int j, int rowNum, int colNum, char[][] grid, boolean[][] visited) {
        boolean insideBoundary = i >= 0 && i < rowNum && j >= 0 && j < colNum;
        if (insideBoundary && (visited[i][j] || grid[i][j] == '0')) return 0;
        if (!insideBoundary) return 0;
        else {
            visited[i][j] = true;
            countIsland(i, j - 1, rowNum, colNum, grid, visited);
            countIsland(i + 1, j, rowNum, colNum, grid, visited);
            countIsland(i, j + 1, rowNum, colNum, grid, visited);
            countIsland(i - 1, j, rowNum, colNum, grid, visited);
            return 1;
        }
    }
}
