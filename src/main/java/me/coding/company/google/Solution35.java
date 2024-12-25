package me.coding.company.google;

import java.util.Arrays;

class Solution35 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int l = 0, r = 0;
        int num = 1;
        while (true) {
            boolean moved = false;

            while (isValid(l, r, n, n) && matrix[l][r] == -1) {
                matrix[l][r] = num;
                num++;
                moved = true;
                if (isValid(l, r + 1, n, n) && matrix[l][r + 1] == -1) {
                    l++;
                    break;
                }
                r++;
            }
            while (isValid(l, r, n, n) && matrix[l][r] == -1) {
                matrix[l][r] = num;
                num++;
                moved = true;
                if (isValid(l + 1, r, n, n) && matrix[l + 1][r] == -1) {
                    r--;
                    break;
                }
                l++;
            }
            while (isValid(l, r, n, n) && matrix[l][r] == -1) {
                matrix[l][r] = num;
                num++;
                moved = true;
                if (isValid(l, r - 1, n, n) && matrix[l][r - 1] == -1) {
                    l--;
                    break;
                }
                r--;
            }
            while (isValid(l, r, n, n) && matrix[l][r] == -1) {
                matrix[l][r] = num;
                num++;
                moved = true;
                if (isValid(l - 1, r, n, n) && matrix[l - 1][r] == -1) {
                    r++;
                    break;
                }
                l--;
            }

            if (!moved) break;
        }
        return matrix;
    }

    public boolean isValid(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}