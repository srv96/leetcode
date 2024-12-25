package me.coding.leetcode.top150;

import java.util.Arrays;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < row; i++) dp[i][0] = matrix[i][0] == '0' ? 0 : 1;
        for (int i = 0; i < col; i++) dp[0][i] = matrix[0][i] == '0' ? 0 : 1;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }

        return result * result;
    }
}
