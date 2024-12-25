package me.coding.leetcode.top150;

import java.util.HashSet;
import java.util.Set;

class Solution11 {
    public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        Set<Integer> uniqRow = new HashSet<>();
        Set<Integer> uniqCol = new HashSet<>();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == 0) {
                    uniqRow.add(i);
                    uniqCol.add(j);
                }
            }
        }

        uniqRow.forEach(rowNum -> {
            for (int j = 0; j < colCount; j++) {
                matrix[rowNum][j] = 0;
            }
        });
        uniqCol.forEach(colNum -> {
            for (int i = 0; i < colCount; i++) {
                matrix[i][colNum] = 0;
            }
        });

    }
}
