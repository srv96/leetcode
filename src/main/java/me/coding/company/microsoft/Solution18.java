package me.coding.company.microsoft;

import me.coding.ds.pair.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution18 {
    Queue<Pair<Integer, Integer>> distMap;

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        distMap = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    distMap.add(new Pair<>(i, j));
                }
            }
        }
        while (!distMap.isEmpty()) {
            Pair<Integer, Integer> pos = distMap.poll();
            int i = pos.key;
            int j = pos.value;
            if (isValidPlace(i - 1, j, mat.length, mat[0].length) && mat[i - 1][j] != 0) {
                int min = Math.min(mat[i - 1][j], mat[i][j] + 1);
                if (mat[i - 1][j] != min) {
                    mat[i - 1][j] = min;
                    distMap.add(new Pair<>(i - 1, j));
                }
            }
            if (isValidPlace(i, j - 1, mat.length, mat[0].length) && mat[i][j - 1] != 0) {
                int min = Math.min(mat[i][j - 1], mat[i][j] + 1);
                if (mat[i][j - 1] != min) {
                    mat[i][j - 1] = min;
                    distMap.add(new Pair<>(i, j - 1));
                }
            }
            if (isValidPlace(i, j + 1, mat.length, mat[0].length) && mat[i][j + 1] != 0) {
                int min = Math.min(mat[i][j + 1], mat[i][j] + 1);
                if (mat[i][j + 1] != min) {
                    mat[i][j + 1] = min;
                    distMap.add(new Pair<>(i, j + 1));
                }
            }
            if (isValidPlace(i + 1, j, mat.length, mat[0].length) && mat[i + 1][j] != 0) {
                int min = Math.min(mat[i + 1][j], mat[i][j] + 1);
                if (mat[i + 1][j] != min) {
                    mat[i + 1][j] = min;
                    distMap.add(new Pair<>(i + 1, j));
                }
            }
        }
        return mat;
    }

    private boolean isValidPlace(int i, int j, int row, int col) {
        return (i >= 0 && i < row && j >= 0 && j < col);
    }
}
