package me.coding.leetcode.code;

class Solution20 {
    //int[][] memo;

    public boolean isValidLocation(int i, int j, int m, int n) {
        if (i < m && j < n) return true;
        return false;
    }

    public int uniquePaths(int m, int n) {
        // memo = new int[m][n];
        return unique(0, 0, m, n);
    }

    private int unique(int i, int j, int m, int n) {
        if (!isValidLocation(i, j, m, n)) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        return unique(i + 1, j, m, n) + unique(i, j + 1, m, n);
    }
}
