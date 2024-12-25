package me.coding.leetcode.top150;

import java.util.LinkedList;
import java.util.Queue;

class Solution50 {
    public boolean isValid(int rowCount, int colCount, int i, int j) {
        if (i >= 0 && i < rowCount && j >= 0 && j < colCount) return true;
        return false;
    }
    public int orangesRotting(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        if (rowCount == 0 || colCount == 0) return 0;
        if (rowCount==1&&colCount==1){
            if(grid[0][0]==0||grid[0][0]==2)return 0;
            else return -1;
        }
        boolean[][] visited = new boolean[rowCount][colCount];
        Queue<int[]> coordinateQueue = new LinkedList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 2) {
                    coordinateQueue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int time = 0;
        if(coordinateQueue.isEmpty()){
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return 0;
        }
        while (!coordinateQueue.isEmpty()) {
            int size = coordinateQueue.size();
            boolean timeFlag = false;
            for (int i = 0; i < size; i++) {
                int[] coordinate = coordinateQueue.poll();
                if (isValid(rowCount, colCount, coordinate[0] - 1, coordinate[1]) && !visited[coordinate[0] - 1][coordinate[1]] && grid[coordinate[0] - 1][coordinate[1]] == 1) {
                    coordinateQueue.offer(new int[]{coordinate[0] - 1, coordinate[1]});
                    visited[coordinate[0] - 1][coordinate[1]] = true;
                    timeFlag = true;
                }
                if (isValid(rowCount, colCount, coordinate[0], coordinate[1] - 1) && !visited[coordinate[0]][coordinate[1] - 1] && grid[coordinate[0]][coordinate[1] - 1] == 1) {
                    coordinateQueue.offer(new int[]{coordinate[0], coordinate[1] - 1});
                    visited[coordinate[0]][coordinate[1] - 1] = true;
                    timeFlag = true;
                }
                if (isValid(rowCount, colCount, coordinate[0], coordinate[1] + 1) && !visited[coordinate[0]][coordinate[1] + 1] && grid[coordinate[0]][coordinate[1] + 1] == 1) {
                    coordinateQueue.offer(new int[]{coordinate[0], coordinate[1] + 1});
                    visited[coordinate[0]][coordinate[1] + 1] = true;
                    timeFlag = true;
                }
                if (isValid(rowCount, colCount, coordinate[0] + 1, coordinate[1]) && !visited[coordinate[0] + 1][coordinate[1]] && grid[coordinate[0] + 1][coordinate[1]] == 1) {
                    coordinateQueue.offer(new int[]{coordinate[0] + 1, coordinate[1]});
                    visited[coordinate[0] + 1][coordinate[1]] = true;
                    timeFlag = true;
                }
            }
            if (timeFlag) time++;
        }
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return time;
    }
}
