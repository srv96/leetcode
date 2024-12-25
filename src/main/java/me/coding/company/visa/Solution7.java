package me.coding.company.visa;

import java.util.Arrays;

class Solution7 {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1) return matrix[0][0];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                else if (j == col - 1) matrix[i][j] += Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]);
                else matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]));
            }
        }
        return Arrays.stream(matrix[row - 1]).min().getAsInt();
    }
}