package me.coding.company.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution12 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            Arrays.fill(visited[i], false);
        }
        int i = 0, j = 0;
        boolean brk = false;
        while (!brk) {
            brk = true;
            while (isValidPlace(i, j, row, col) && !visited[i][j]) {
                brk = false;
                visited[i][j] = true;
                result.add(matrix[i][j]);
                j++;
            }
            i++;j--;
            while (isValidPlace(i, j, row, col) && !visited[i][j]){
                brk = false;
                visited[i][j] = true;
                result.add(matrix[i][j]);
                i++;
            }
            i--;j--;
            while (isValidPlace(i, j, row, col) && !visited[i][j]){
                brk = false;
                visited[i][j] = true;
                result.add(matrix[i][j]);
                j--;
            }
            i--;j++;
            while (isValidPlace(i, j, row, col) && !visited[i][j]){
                brk = false;
                visited[i][j] = true;
                result.add(matrix[i][j]);
                i--;
            }
            i++;j++;
        }
        return result;
    }

    private boolean isValidPlace(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
