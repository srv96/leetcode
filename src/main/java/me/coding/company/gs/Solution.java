package me.coding.company.gs;

import java.util.List;

public class Solution {
    public static int countConnections(List<List<Integer>> matrix) {
        int rowSize = matrix.size();
        int colSize = matrix.get(0).size();
        int count = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if(matrix.get(i).get(j)==1)count += getConnection(matrix, i, j, rowSize, colSize);
            }
        }
        return count / 2;
    }

    private static int getConnection(List<List<Integer>> matrix, int i, int j, int rowSize, int colSize) {
        int count = 0;
        if (isValidPoint(matrix, i - 1, j - 1, rowSize, colSize)) count++;
        if (isValidPoint(matrix, i - 1, j, rowSize, colSize)) count++;
        if (isValidPoint(matrix, i - 1, j + 1, rowSize, colSize)) count++;
        if (isValidPoint(matrix, i, j - 1, rowSize, colSize)) count++;
        if (isValidPoint(matrix, i, j + 1, rowSize, colSize)) count++;
        if (isValidPoint(matrix, i + 1, j - 1, rowSize, colSize)) count++;
        if (isValidPoint(matrix, i + 1, j, rowSize, colSize)) count++;
        if (isValidPoint(matrix, i + 1, j + 1, rowSize, colSize)) count++;
        return count;
    }

    private static boolean isValidPoint(List<List<Integer>> matrix, int i, int j, int rowSize, int colSize) {
        if (i < 0 || i >= rowSize || j < 0 || j >= colSize) return false;
        else if (matrix.get(i).get(j) == 0) return false;
        else return true;
    }
}
