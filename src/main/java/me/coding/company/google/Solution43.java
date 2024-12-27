package me.coding.company.google;

import me.coding.ds.list.ListNode;

import java.util.Arrays;

class Solution43 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int r = 0, c = 0, rf = 0, cf = 0;
        while (head != null) {
            while (c < n && head != null && matrix[r][c] == -1) {
                matrix[r][c] = head.val;
                head = head.next;
                if (c < n - 1 && matrix[r][c + 1] == -1) c++;
            }
            if (r < m - 1 && matrix[r + 1][c] == -1) r++;
            while (r < m && head != null && matrix[r][c] == -1) {
                matrix[r][c] = head.val;
                head = head.next;
                if (r < m - 1 && matrix[r + 1][c] == -1) r++;
            }
            if (c >= 1 && matrix[r][c - 1] == -1) c--;
            while (c >= 0 && head != null && matrix[r][c] == -1) {
                matrix[r][c] = head.val;
                head = head.next;
                if (c >= 1 && matrix[r][c - 1] == -1) c--;
            }
            if (r >= 1 && matrix[r - 1][c] == -1) r--;
            while (r >= 0 && head != null && matrix[r][c] == -1) {
                matrix[r][c] = head.val;
                head = head.next;
                if (r >= 1 && matrix[r - 1][c] == -1) r--;
            }
            rf++;
            cf++;
            r = rf;
            c = cf;
        }
        return matrix;
    }
}